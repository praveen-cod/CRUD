# Build stage
FROM maven:3.9.14-eclipse-temurin-25 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8000}"]