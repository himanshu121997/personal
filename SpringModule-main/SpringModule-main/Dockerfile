FROM adoptopenjdk/openjdk11:alpine-jre
ADD customer/target/customer.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

