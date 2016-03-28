# multipart-demo

Multipart form demo with WildFly Swarm

## Usage

### Run server

``` sh
$ ./mvnw clean package && java -jar target/multipart-demo-swarm.jar
```

### Access to API

``` sh
$ curl -X POST -F 'file=@README.md' http://localhost:8080/media
```
