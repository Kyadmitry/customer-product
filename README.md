# customer-product
It is a CRUD service with Postgres

### Technologies used:
* JDK 12+
* Spring Boot 2
* Spring Security
* Gradle 6.7.1
* Hibernate
* Docker-compose
* JUnit/Mockito
* Swagger
* Postgresql
* H2

### Required software:
* Docker

### How to run the application:
1. Download the project
2. Run the command: ```docker-compose up --build```

This application uses Spring Security, so you need to register and log in.
There is a simple role model: a simple user (with the USER role), when entering the system, can see a page with his first name, last name,
the Exit button and the "Swagger (only for admin)" button inaccessible to him.
A user with the ADMIN role can see the same page, but he has access to the application's Swagger using the "Swagger (administrator only)" button.
To get the ADMIN role, you must enter "admin" in the "Login" field. Otherwise, the USER role is created.


