#!/bin/bash
function result {
    if [[ "$?" -ne 0 ]]; then
        printf "FAILED!\n"
        exit 1
    else
        printf "SUCCESS!\n"
    fi
}

if [ -z "$1" ]; then
    printf "ERROR: A deployment target is required!\n"
    exit 1
elif [[ "$1" != "vistool-dev" && "$1" != "vistool-test" ]]; then
    printf "ERROR: Invalid deployment target!\n"
    exit 1
fi

printf "======================= deploy.sh =======================\n"
printf "Build Target: vistool-web-service\n"
printf "Deployment Target: $1\n\n"

printf "1. Building vistool-web-service locally... "
mvn clean package -P $1 -DskipTests=true > /dev/null 2>&1
result

printf "2. Copying vistool-web-service to $1... "
scp target/vistool-web-service.war $1:~ > /dev/null 2>&1
result

printf "3. Deploying vistool-web-service on $1... "
ssh $1 "sudo rm /usr/local/tomcat9/webapps/vistool-web-service.war && sleep 10 && sudo mv ~/vistool-web-service.war /usr/local/tomcat9/webapps/vistool-web-service.war" > /dev/null 2>&1
result
exit 0
