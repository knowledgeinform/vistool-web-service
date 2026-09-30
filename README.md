# VisTool-Web-Service
Vistool-Web-Service is a web API using Spring Boot. 

## Copyright
© 2021 The Johns Hopkins University Applied Physics Laboratory LLC.  All Rights Reserved.

## Installation/Version Control Instructions
Vistool-Web-Service uses git for version control. To clone the repository, type 'git clone https://sd-bitbucket.jhuapl.edu/scm/vis/vistool-web-service.git'
into your command line tool at the desired path.

## Configuration Instructions

### Using Docker
The web service is containerized. Developers will need to add the vistool_secret.env file found on the wiki to their /docker directory: https://aplwiki.jhuapl.edu/confluence/display/SESSIG/Vistool+Encryption

Use the following commands to build and run containers:
`docker-compose build` Builds the containers in your composition but does not run them. Append the `--build-arg` argument to build an image with a defined argument (e.g., `PROFILE=local-dev-secure`). **NB:** Note that the PROFILE build argument defaults to `local-dev-secure`.

`docker-compose up` Launches the containers in your composition, replacing any already running instances. It will not rebuild containers if a built version already exists. Append the `--build` argument to force a rebuild. Append the name of a service (e.g. `vistool-ws-dev`) to limit the command to a specific service.
**NB:** If you need to change a build argument for the composition (e.g., PROFILE), you need to rebuild the container first using the `docker-compose build` command.

`docker-compose stop` Stops the containers in your composition.

`docker-compose down` Stops and destroys the containers in your composition. All data contained in the containers will be lost. Append `--volumes` to also destroy volumes.

#### Running the Application
To run the application, use the commands above to run the default docker-compose file (`docker-compose.yml`). Note that the integration tests will not run as part of the application build and deployment. Integration tests should be run separately (see next section).

#### Running the Integration Tests
To run the integration tests, use `docker-compose -f docker-compose-integration.yml up`

#### DEPRECATED: Software Prerequisites - These are set in the Docker container and do not need to be installed locally if you are using Docker.
* Maven
  * https://maven.apache.org/download.cgi
* OpenJDK 11
  * Win/Nix: https://jdk.java.net/java-se-ri/11
  * Mac: https://formulae.brew.sh/formula/openjdk@11

#### DEPRECATED: Environment Variable - This does not need to be set locally if using Docker
An environment variable named `VISTOOL_SECRET` needs to be set in order for the Vistool Web Service to be able to decrypt
the application's encrypted properties. The value the variable needs to be set to can be found on the following VisTool
wiki: https://aplwiki.jhuapl.edu/confluence/display/SESSIG/Vistool+Encryption

#### APL Root Certificate
If you have not done so before, follow [these instructions from ITSD](https://aplprod.servicenowservices.com/sp?id=kb_article&sys_id=6bdc10f11bf1641066d443f1f54bcb84)
  to use the APL Root CA Certificate with Java applications.

## Steps to Run Locally - Using Docker is recommended.
* Navigate to the repository root and run `mvn spring-boot:run`


## Deployment Instructions
Vistool Web Service is a Maven project. To create a local artifact that can be used for deployment, run 'mvn clean package'.
For the most part though, artifacts will be created for branches built through Bamboo, and saved to sd-artifactory.
