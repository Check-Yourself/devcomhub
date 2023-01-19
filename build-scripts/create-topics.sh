#!/bin/bash

# Create topic 'topic1' with 1 partitions and a replication factor of 1
kafka-topics --create --topic topic1 --partitions 1 --replication-factor 1 --zookeeper zookeeper:2181

# Create topic 'topic2' with 1 partitions and a replication factor of 1
kafka-topics --create --topic topic2 --partitions 1 --replication-factor 1 --zookeeper zookeeper:2181

# Send test message to topic1
echo "Test message for topic1" | kafka-console-producer --broker-list localhost:9092 --topic topic1

# Send test message to topic2
echo "Test message for topic2" | kafka-console-producer --broker-list localhost:9092 --topic topic2
