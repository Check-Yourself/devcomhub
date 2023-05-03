#!/bin/bash
cd ..
echo "start building an artifact"
./mvnw clean package;
echo "finish building an artifact"

echo "start register schemas"
./mvnw schema-registry:register
echo "finish register schemas"

echo "to finish type Ctrl+C"
sleep 6000000
