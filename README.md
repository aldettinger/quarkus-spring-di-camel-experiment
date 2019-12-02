CAMEL QUARKUS SPRING DI EXPERIMENT WITH CAMEL
===
Summary
---

It looks that most interesting Spring annotations are supported.

In this experiment, I've migrated a Spring Boot application to camel-quarkus-main/quarkus-spring-di.
It looks that they play well together.
I have replaced @SpringBootApplication with @ApplicationScoped, but I think it can't be generalized.

For the health-check, I've replaced the Spring Boot actuator with quarkus-smallrye-health with success.

Camel users would use @ImportResource to load XML defined routes. I think it's not in scope for JeSB, however the annotation does not report a build time error while it looks to be ignored.
