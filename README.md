## customer-product
It is a CRUD service with Postgres

# Technologies used:
* JDK 8+
* Spring Boot 2
* Spring Security
* Gradle 6.7.1
* Hibernate
* Docker-compose
* JUnit/Mockito
* Swagger
* Postgresql

# Required software:
* Docker

# How to run the application:
1. Download the project
2. Run the command: docker-compose up

There is Spring Security, so you have to sign up and login.
There is a simple role model: simple user (with USER role) can login and then he can see page with his firstname, lastname and buttom 'Exit'.
User with ADMIN role can see the same page and he can see Swagger of application.
You have to put 'admin' into login input for getting ADMIN role. A USER role is created in other cases.


