FROM openjdk:19-jdk-alpine3.16 as build

WORKDIR /builder

COPY . .

RUN ./gradlew :bootJar

FROM openjdk:19-jdk-alpine3.16

WORKDIR /app

COPY --from=build /builder/build/libs/qualidade-ar-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT java -jar qualidade-ar-0.0.1-SNAPSHOT.jar

