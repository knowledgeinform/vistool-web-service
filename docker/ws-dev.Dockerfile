# Stage 1: Build the WS
FROM maven:3.8.1-jdk-11 AS build
WORKDIR /project

# Build args, the default will be local-dev-secure if no --build-arg PROFILE=<profile> or --build-arg=<skiptests_boolean> is passed on build.
ARG PROFILE=local-dev-secure
ARG SKIPTESTS=true

# Configure Maven to use SD Artifactory
COPY ./docker/settings.xml /usr/share/maven/conf/settings.xml
COPY ./docker/assets/apl-certs/JHUAPL-MS-Root-CA-05-21-2038-B64-text.cer .

# Trust the internal CA before Maven reaches out to Artifactory during the build.
RUN if [ -f "$JAVA_HOME/jre/lib/security/cacerts" ]; then \
      CACERTS="$JAVA_HOME/jre/lib/security/cacerts"; \
    else \
      CACERTS="$JAVA_HOME/lib/security/cacerts"; \
    fi && \
    echo "Using cacerts: $CACERTS" && \
    keytool -importcert -noprompt -alias JHUAPL_ROOT -keystore "$CACERTS" -storepass changeit -file JHUAPL-MS-Root-CA-05-21-2038-B64-text.cer



# Cache dependencies.
ADD pom.xml .
RUN mvn verify clean --fail-never

# Copy source files to build:
COPY . .

# Build
RUN mvn clean package -P ${PROFILE} -Dmaven.test.skip=${SKIPTESTS} -DargLine="-D$(cat ./docker/vistool_secret.env)"

# Stage 2: Run WS in Tomcat
FROM tomcat:9.0.112-jdk11-temurin-noble

RUN apt-get update && apt-get install iputils-ping -y


# Install APL Root CA cert to system CA store and install ping
COPY docker/assets/apl-certs/* /usr/local/share/ca-certificates/
RUN apt-get update
RUN apt-get install iputils-ping ca-certificates -y
RUN update-ca-certificates


COPY ./docker/assets/apl-certs/JHUAPL-MS-Root-CA-05-21-2038-B64-text.crt /tmp/JHUAPL_ROOT.crt

RUN keytool -delete -alias JHUAPL_ROOT -cacerts -storepass changeit 2>/dev/null || true \
 && keytool -importcert -noprompt -alias JHUAPL_ROOT -cacerts -storepass changeit -file /tmp/JHUAPL_ROOT.crt \
 && rm -f /tmp/JHUAPL_ROOT.crt

COPY ./docker/apache-context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY ./docker/apache-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ./docker/apache-server.xml /usr/local/tomcat/conf/server.xml

COPY ../src/main/resources/vistool.p12 /usr/local/tomcat/conf

COPY ./docker/setenv.sh /usr/local/tomcat/bin/setenv.sh

COPY --from=build /project/target/*.war /usr/local/tomcat/webapps

COPY ./docker/is-db-updater-done.sh .

CMD sh is-db-updater-done.sh vistool-db-updater && /usr/local/tomcat/bin/catalina.sh jpda run
