FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run

FROM openjdk:11.0
WORKIR /app
COPY --from=build /app/target/Uber.jar /app/
EXPOSE 9090
CDM [ "java","-jar","Uber.jar" ]