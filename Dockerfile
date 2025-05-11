FROM eclipse-temurin:23-jre-alpine
EXPOSE 8085

WORKDIR /app
COPY target/student-service-*.jar ./student-service.jar

ENTRYPOINT ["java", "-jar", "student-service.jar"]
