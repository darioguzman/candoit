FROM java:8
WORKDIR /app
COPY target/weather-application-0.0.1-SNAPSHOT.war /app/spring-boot-app.war
ENTRYPOINT ["java","-jar","spring-boot-app.war"]