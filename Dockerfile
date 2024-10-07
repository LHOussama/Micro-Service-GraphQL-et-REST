FROM openjdk:17-alpine3.14
WORKDIR /app
COPY target/BanqueDigital-0.0.1-SNAPSHOT.jar BanqueDigital.jar
ENTRYPOINT ["java", "-jar", "BanqueDigital.jar"]
EXPOSE 8080