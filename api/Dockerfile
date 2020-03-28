# Building state

FROM maven AS BUILD_STAGE

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

# Running stage

FROM openjdk:11.0.6-jre-slim

WORKDIR app/

COPY --from=BUILD_STAGE /app/target/*.jar app.jar

ENTRYPOINT java -jar app.jar
