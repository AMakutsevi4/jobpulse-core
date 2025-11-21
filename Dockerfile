FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:25-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV JAVA_OPTS="-XX:InitialRAMPercentage=75 -XX:MaxRAMPercentage=75 -Dconfig.override_with_env_vars=true -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["java", "-jar", "app.jar"]