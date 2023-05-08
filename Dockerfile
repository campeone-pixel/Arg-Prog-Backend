FROM amazoncorretto-17:latest
MAINTAINER Mati
COPY target/conection-0.0.1-SNAPSHOT.jar conection-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/conection-0.0.1-SNAPSHOT.jar"]