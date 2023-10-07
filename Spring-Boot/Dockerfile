FROM openjdk:11
WORKDIR /app
COPY /target/Spring-Boot-0.0.1-SNAPSHOT.jar /app/springboot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot.jar"]