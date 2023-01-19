#!/bin/bash
cd ..
mvn clean install -DskipTests
docker build -t lecture-service .
docker run -d -p 8084:8080 --name lecture-service lecture-service
