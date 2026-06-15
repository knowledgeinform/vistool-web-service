FROM maven:3.8.1-jdk-11 AS build
WORKDIR /project

# Build args, the default will be local-dev-secure if no --build-arg PROFILE=<profile> is passed on build.
ARG PROFILE=local-dev-secure

ENV PROFILE=$PROFILE

# Configure Maven to use SD Artifactory
COPY ./docker/settings.xml /usr/share/maven/conf/settings.xml

# Cache dependencies.
ADD pom.xml .
RUN mvn verify clean --fail-never

# Copy source files to build:
COPY . .

COPY ./docker/is-db-updater-done.sh .

# Build and run integration tests
CMD sh is-db-updater-done.sh vistool-db-updater-test && mvn test -P ${PROFILE} -DargLine="-D$(cat ./docker/vistool_secret.env)"
