# Spring Boot Application

## Descripción

Esta es una aplicación Spring Boot que proporciona una API RESTful para gestionar vuelos y tarifas. La aplicación incluye endpoints para buscar vuelos por fechas y ciudades, así como para gestionar tarifas de vuelos.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL
- Swagger/OpenAPI 
- JUnit 5
- Mockito
- MapStruct
- Lombok
- Spring Boot Actuator

## Prerrequisitos

- JDK 17 
- Maven
- MySQL

## Configuración

1. Clona el repositorio:
    ```bash
    git clone https://github.com/saraduque1/flights-backend.git
    cd flights-backend
    ```

2. Configura la base de datos en el archivo `application.properties`:
    ```properties
    spring.application.name=nombre_de_la_aplicacion
    server.port=8080
    spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_la_base_de_datos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Ejecuta el script SQL "import.sql" para crear las tablas necesarias e insertar los datos de prueba.

## Construcción y Ejecución

Para construir y ejecutar la aplicación, puedes usar los siguientes comandos de Maven:

1. Construir el proyecto:
    ```bash
    mvn clean install
    ```

2. Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

La aplicación estará disponible en `http://localhost:8080`.

## Documentación de la API

La documentación de la API está disponible en `http://localhost:8080/swagger-ui.html`.

## Configuración de Lombok y MapStruct

El proyecto está configurado para usar Lombok y MapStruct. No olvides instalar el plugin de Lombok en tu IDE para que funcione correctamente.
