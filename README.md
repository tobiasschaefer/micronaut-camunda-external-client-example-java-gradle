# Micronaut Camunda External Client Example

This example shows how to apply the external task pattern: the server with a BPMN process will create calculations which will be solved by an external task client.

The server is implemented with the [Micronaut Camunda Integration](https://github.com/NovatecConsulting/micronaut-camunda-bpm).
The external client is implemented with the [Micronaut Camunda External Client](https://github.com/NovatecConsulting/micronaut-camunda-external-client).

Start Server:

`./gradlew run -p server`

This will output something like:

```
Created calculation: 18*90=?
Created calculation: 77*34=?
Created calculation: 37*23=?
Created calculation: 62*35=?
Created calculation: 89*53=?
```

Start Client:

`./gradlew run -p client`

This will output something like:

```
External client calculated 77*34=2618
External client calculated 18*90=1620
External client calculated 37*23=851
External client calculated 62*35=2170
External client calculated 89*53=4717
```
