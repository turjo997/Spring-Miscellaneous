FROM openjdk:22

EXPOSE 9090

ADD target/spring-boot-docker.jar spring-boot-docker.jar

ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]