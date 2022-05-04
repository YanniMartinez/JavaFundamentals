## Pool de conexiones

Se encargará de administrar todas las conexiones a las bases de datos, se encarga de abrir y cerrar sin tener que preocuparnos de ello, se puede generar por diversas formas, una forma es por código propio o mediante JBC de apache, o algun otro como TomCat, JBOSS, etc.

Para ello usaremos la dependencia de Appache Commons DBCP2, para descargar la dependencia selecionamos `clean and build`.

```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.7.0</version>
</dependency>
```

