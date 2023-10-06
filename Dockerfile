FROM openjdk:17
EXPOSE 8083
ADD build/libs/test-todo-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]