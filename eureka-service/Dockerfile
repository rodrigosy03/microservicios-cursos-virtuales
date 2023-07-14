FROM openjdk:8
EXPOSE 8671
COPY "./target/ms-eureka-service-0.0.1-SNAPSHOT.jar" "ms-eureka-service.jar"  
ENTRYPOINT [ "java", "-jar", "ms-eureka-service.jar" ]