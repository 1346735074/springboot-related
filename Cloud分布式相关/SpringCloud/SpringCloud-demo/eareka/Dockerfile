FROM hub.c.163.com/library/java:openjdk-9-jre

MAINTAINER noly 1346735074@qq.com

ADD target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/app.jar"]