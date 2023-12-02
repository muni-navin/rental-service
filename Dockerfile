FROM openjdk:17
EXPOSE 8080
ADD target/service-rental.jar service-rental.jar
ENTRYPOINT ["java","-jar","service-rental.jar"]