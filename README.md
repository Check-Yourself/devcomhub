# devcomhub

## local development
To start the local environment you need preinstalled:
 - docker

### Running of services

- (!) Pre requirements: Before run services, make sure you build schema-registry-service. For more info see README in schema-registry-service  
- There is a run script inside any module of the project (see README file)

### Running of environment
- To build and run the local environment (e.g. DB, Kafka etc) use the following script:
```shell
cd build-scripts; docker-compose -f docker-compose.yml -p docker-compose-devcomhub up -d
```
- To register schemas on kafka cluster use schema-registry-service
