# Stage 1: Build the Spring Boot app
FROM eclipse-temurin:23-jdk AS builder

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Copy source code
COPY src src

# Build the project, skip tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create lightweight runtime image
FROM eclipse-temurin:23-jre

WORKDIR /app

# Copy the JAR built in stage 1
COPY --from=builder /app/target/*.jar app.jar

# Expose port (Spring Boot will read PORT env variable)
EXPOSE 9090

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
