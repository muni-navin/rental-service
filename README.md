# Rental service

## Running the service locally

In order to run the service locally, you need to provide the following jvm parameter:

...
-Dspring.profiles.active=local
...

## Swagger documentation url

...
http://localhost:8080/swagger-ui/index.html
...

## Actuator:

...
http://localhost:8080/actuator
...

## SQL DB connection

# ADD below dependency

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>

# Add below properties in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/rental?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=RentalService2023
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.datasource.platform=mysql
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

#Docker commands
docker -v
running: docker run -p 9090:8080 service-rental.jar
Stopping : docker stop --time=30 ddfdb30ff369
IP Address : docker inspect --format="{{.NetworkSettings.IPAddress}}" ddfdb30ff369
