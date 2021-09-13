FROM java:8

EXPOSE 7070

ADD target/productcentral.jar productcentral.jar

ENTRYPOINT ["java","-jar","productcentral.jar"]