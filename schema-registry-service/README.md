# schema-registry-service
The main purpose of the service is to store and register avro schemas for kafka-schema-registry.
Also, some services have dependencies on this service, because this service generates POJOs according to Avro schemas.
The service does not run and acts as a lib and publisher schemas. 

## local development
### Pre Requirements 
- to register schemas, make sure a kafka cluster is running 

(!) The service does not run and acts as a lib and publisher schemas.

Use that command to build POJOs and register schemas on kafka cluster:
```shell
cd build-scripts; .\start.sh;
```
- For checking registered schemas use that GET request:  http://localhost:8081/schemas
