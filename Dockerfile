FROM openjdk:17
EXPOSE 8080
ADD build/libs/test-todo-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=db,logging","-jar","/app/app.jar"]