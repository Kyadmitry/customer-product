# customer-product
It is a CRUD service with Postgres

### Technologies used
* Spring Boot 2
* Spring Security
* Hibernate
* Docker-compose
* JUnit/Mockito
* Swagger
* Postgresql
* H2

### Required software
* Docker

### How to run the application
1. Download the project
2. Run the command: ```docker-compose up```

This application uses Spring Security, so you need to register and log in.
There is a simple role model: a simple user (with the USER role), when entering the system, can see a page with his first name, last name,
the Exit button and the "Swagger (only for admin)" button inaccessible to him.
A user with the ADMIN role can see the same page, but he has access to the application's Swagger using the "Swagger (administrator only)" button.
To get the ADMIN role, you must enter "admin" in the "Login" field. Otherwise, the USER role is created.

### How to test the application
- To create a customer:
  <code>curl -X POST "http://localhost:8080/api/v1/customers" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"title\": \"someTitle\"}"</code>
  
- To get customers:
<code>curl -X GET "http://localhost:8080/api/v1/customers" -H "accept: */*"</code>
  
- To get a customer by ID:
<code>curl -X GET "http://localhost:8080/api/v1/customers/{customerId}" -H "accept: */*"</code>

- To update a customer by ID:
<code>curl -X PUT "http://localhost:8080/api/v1/customers/{customerId}" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"title\": \"newTitle\"}"</code>
  
- To delete a customer by ID:
<code>curl -X DELETE "http://localhost:8080/api/v1/customers/{customerId}" -H "accept: */*"</code>

- To edit a customer by ID:
<code>curl -X PATCH "http://localhost:8080/api/v1/customers/{customerId}" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"title\": \"newTitle\"}"</code>
  
- To create a new product for a customer:
<code>curl -X POST "http://localhost:8080/api/v1/customers/{customerId}" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"description\": \"string\", \"price\": 14, \"title\": \"string\"}"</code>

- To get customer products:
<code>curl -X GET "http://localhost:8080/api/v1/customers/59b82738-3112-45d1-85ed-28d181436a1f/products" -H "accept: */*"</code>

- To get a product by ID:
<code>curl -X GET "http://localhost:8080/api/v1/products/{productId}" -H "accept: */*"</code>
  
- To update a customer by ID:
<code>curl -X PUT "http://localhost:8080/api/v1/products/{productId}" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"description\": \"NewString\" \"price\": 98, \"title\": \"string\"}"</code>

- To edit a product by ID:
<code>curl -X PATCH "http://localhost:8080/api/v1/products/{productId}" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"description\": \"EditedString\"}"</code>
  
- To delete a product by ID:
<code>curl -X DELETE "http://localhost:8080/api/v1/products/{productId}" -H "accept: */*"</code>
