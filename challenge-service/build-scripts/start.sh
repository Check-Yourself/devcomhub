#!/bin/bash
cd ..
mvn clean install -DskipTests
docker build -t challenge-service .
docker run -d -p 8082:8080 --name challenge-service challenge-service
