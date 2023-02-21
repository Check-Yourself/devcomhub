#!/bin/bash
cd ..
./mvnw clean package -DskipTests
docker build -t contribution-service .
docker run -d -p 8083:8080 --name contribution-service contribution-service
