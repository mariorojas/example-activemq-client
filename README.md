# example-activemq-client

Cliente en Spring Boot que expone un recurso para interactuar con un servidor ActiveMQ.

Las propiedades de configuración del enlace con el servidor se encuentran descritas en **application.yml** como se muestra a continuación:

```
spring:
  activemq:
    broker-url: tcp://localhost:61616
    password: admin
    user: admin
```

El servidor ActiveMQ puede descargarse desde el siguiente [enlace](http://activemq.apache.org/download.html).