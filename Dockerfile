# Use official OpenJDK runtime image
FROM openjdk:17-jre-slim

# Set working directory
WORKDIR /app

# Copy the JAR file to the container
COPY BANKOFKIGALI.jar /app/BANKOFKIGALI.jar

# Run the application
ENTRYPOINT ["java", "-jar", "BANKOFKIGALI.jar"]
