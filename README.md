# customer-product
CRUD service with Postgres

1) Download the project
2) Run the command: docker-compose up

There is Spring Security, so you have to sign up and login.
There is a simple role model: simple user (with USER role) can login and then he can see page with his firstname, lastname and buttom 'Exit'.
User with ADMIN role can see the same page and he can see Swagger of application.
You have to put 'admin' into login input for getting ADMIN role. A USER role is created in other cases.


