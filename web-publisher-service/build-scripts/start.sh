#!/bin/bash
cd ..
./mvnw clean package -DskipTests
docker build -t web-publisher-service .
docker run -d -p 8086:8080 --name web-publisher-service web-publisher-service
