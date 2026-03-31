# Build stage
FROM maven:3.9.9-eclipse-temurin-25 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 3001

ENTRYPOINT ["java", "-jar", "app.jar"]