# Micronaut Camunda External Client Example

This example shows how to apply the external task pattern: the server with a BPMN process will create calculations which will be solved by an external task client.

The server is implemented with the [Micronaut Camunda Integration](https://github.com/camunda-community-hub/micronaut-camunda-bpm).
The external client is implemented with the [Micronaut Camunda External Client](https://github.com/camunda-community-hub/micronaut-camunda-external-client).

## Server

To start the server:

`./gradlew run -p server`

This will output something like:

```
Created calculation: 18*90=?
Created calculation: 77*34=?
Created calculation: 37*23=?
Created calculation: 62*35=?
Created calculation: 89*53=?
```

## Client

To start the client:

`./gradlew run -p client`

This will output something like:

```
External client calculated 77*34=2618
External client calculated 18*90=1620
External client calculated 37*23=851
External client calculated 62*35=2170
External client calculated 89*53=4717
```

## Client (GraalVM)

The client can also by compiled for GraalVM which will minimize start up times.

The following steps are based on instructions from https://github.com/camunda-community-hub/micronaut-camunda-external-client#graalvm

```
sdk use java 21.0.0.2.r11-grl
export PATH=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0.2/Contents/Home/bin:$PATH
export JAVA_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0.2/Contents/Home
cd client
../gradlew build
mkdir -p src/main/resources/META-INF/native-image/client
java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image/client -jar build/libs/client-0.0.1-SNAPSHOT-all.jar
../gradlew clean nativeImage
build/native-image/application
```
