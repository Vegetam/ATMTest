FROM openjdk:8
EXPOSE 8080
ADD target/atm-docker.jar atm-docker.jar
ENTRYPOINT ["java","-jar","/atm-docker.jar"]