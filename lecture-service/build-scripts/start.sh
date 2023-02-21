#!/bin/bash
cd ..
./mvnw clean package -DskipTests
docker build -t lecture-service .
docker run -d -p 8084:8080 --name lecture-service lecture-service
