# Use a base image that has JDK installed
FROM maven:3.8.5-openjdk-17 as build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven files first to leverage caching
COPY pom.xml ./
COPY src ./src

# Build the application
RUN mvn clean package "-Dspring.profiles.active=build"

# Use a lightweight image for running the app
FROM openjdk:17

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8080