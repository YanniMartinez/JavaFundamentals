# JDBC en proyecto Maven

Este proyecto tiene como objetivo describir el uso de base de datos mediante Maven.

## Aspectos importantes
* Pom: Este archivo contiene el manejo de las dependencias.

## Manejo de dependencias de BD en el pom
Para ello es necesario agregar la siguiente dependencia en el Pom:

```
<dependencies>
    <dependency>
    
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.19</version>
    </dependency>
</dependencies>
```

Para que se descargue la dependencia del proyecto hay que presionar `clean and build`(en eclipse posiblemente no sea necesario este paso), dirigirse a Maven dependencies y verificar que se encuentra ahí.

## Creación de clase que conecte con la BD
Crear dentro del paquete test una clase que nos servirá para mandar a llamar la dependencia.