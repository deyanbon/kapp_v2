FROM openjdk:17 AS kapp
LABEL authors="dbontch"

#RUN mkdir data

ADD target/kapp-2.0.0-SNAPSHOT.jar kapp.jar

ENTRYPOINT ["java", "-jar", "kapp.jar"]
EXPOSE 8080
