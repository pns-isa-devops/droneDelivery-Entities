#!/bin/bash

#Preparing environment
cd ../../drone-delivery/Web
echo "Compiling the Drone Delivery system Web component"
mvn -q -DskipTests clean package
cp ./target/Web.war ../../docker/drone-delivery/.
mvn clean
echo "Done"

# building the docker image
cd ../../docker/drone-delivery/
docker build -t djotiham/dd-internal .
# to remove old images
# docker rmi $(docker images -qa -f 'dangling=true')

# cleaning up the environment
rm -rf Web.war
