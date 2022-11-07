FROM gradle:7.5.1-jdk17-alpine as build
COPY . .
RUN gradle bootJar \
    && chown root:root home/gradle/build/libs/AutoGatrorBackend-0.0.1-SNAPSHOT.jar

FROM openjdk:17 as final
ARG JAR_FILE=*.jar
COPY --from=build home/gradle/build/libs/AutoGatrorBackend-0.0.1-SNAPSHOT.jar AutoGatrorBackend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "AutoGatrorBackend-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080