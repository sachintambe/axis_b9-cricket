From openjdk:8

#Adding and renaming the jar file 

ADD /target/springboot-demo-0.1.jar cricketapp.jar

#expose 
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "cricketapp.jar" ]