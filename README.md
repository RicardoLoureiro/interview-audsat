# Getting Started
### Prerequisite
* JAVA JDE 8+
* JAVA JDK
* Docker(optional)

### About
* Used IntelliJ IDE.
* Seeds are provide to make easy tests (see bellow).

### Runing on IDE
* Pull the code on a folder of your preference.
* Open in your favorite IDE.
* Go to src/main/java/ com.audsat.interview
* Run InterviewApplication.java

### Using Docker
* Compile the project using Maven command:
``` 
mvn package
```
* Edit Dockerfile to set the oficial image of the version that is compiled.
* Set the correct name of JAR file generated.
* Run docker command:
```
docker build -t <image-name>:<image_version> .
```
* Finally, start our container:
```
docker run -p 8080:8080 <image-name>:<image_version> 
```
___

### Reference Documentation
About project consideration and documentations, see doc folder on project.

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#io.validation)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#using.devtools)
* [OpenApi 3.0](https://spec.openapis.org/oas/v3.1.0) 
* [H2 Database Engine](https://www.h2database.com/html/main.html)
* [Docker](https://docs.docker.com/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [H2 Database](https://www.youtube.com/watch?v=Peg6v7EtIrw)
