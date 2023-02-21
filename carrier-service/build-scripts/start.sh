#!/bin/bash
cd ..
./mvnw clean package -DskipTests
docker build -t carrier-service .
docker run -d -p 8081:8080 --name carrier-service carrier-service
