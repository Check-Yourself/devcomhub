#!/bin/bash
cd ..
./mvnw clean package -DskipTests
docker build -t user-service .
docker run -d -p 8085:8080 --name user-service user-service
