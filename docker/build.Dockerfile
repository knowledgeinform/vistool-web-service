FROM maven:3.8.1-jdk-11 AS build
WORKDIR /project/

# Retrieve VISTOOL_SECRET from Build Args
ARG VISTOOL_SECRET

# Configure Maven to use SD Artifactory
COPY ./docker/settings.xml /usr/share/maven/conf/settings.xml

# Copy source files to build
COPY . .

# Build Vistool Web Service
RUN mvn -q clean package
