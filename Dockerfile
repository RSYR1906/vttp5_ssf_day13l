# Base image with JDK used to build and run the java application
FROM maven:3.9.9-eclipse-temurin-23

# Labelling the dockerfile with some information
LABEL description ="This is VTTP5 SSF Day 13 Lecture Demo and walkthrough"
LABEL name ="vttp5a-ssf-day13lecture"

ARG APP_DIR=/app

# Directory where the source code will reside
# Directory where u copy the project to (in the next step)
WORKDIR ${APP_DIR}

# Copy the required files and/or directories into the image
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY src src
COPY .mvn .mvn

# Package the application using RUN directive
# This will download the dependencies defined in pom.xml
# Compile and packget to jar
RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT 3000

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", "-jar", "target/SSF-day13lecture-0.0.1-SNAPSHOT.jar", "--server.port=${SERVER_PORT}"]


