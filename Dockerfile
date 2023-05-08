FROM amazoncorretto:17-al2-jdk
MAINTAINER mati
COPY target/conection-0.0.1-SNAPSHOT.jar conection-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/conection-0.0.1-SNAPSHOT.jar"]