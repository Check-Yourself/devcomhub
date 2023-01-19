# devcomhub

## local development
To start the local environment you need preinstalled:
 - maven
 - docker

### Running of services
There is a run script inside any module of the project (see README file)
### Running of environment
To build and run the local environment (e.g. DB, Kafka etc) use the following script:
```shell
cd build-scripts; docker-compose -f docker-compose.yml -p docker-compose-devcomhub up -d
```
