
# Spring Security with JWT

## Detailed descriptions of sample applications are available here
## https://medium.com/@dev.fethi/spring-security-with-jwt-667f8d35dda6

## Tech Stack

* Java 17
* Spring Boot 3.1.0
* Spring Data JPA
* Hibernate
* postgresql


## Installation & Run


```
server:
  port : 8080
spring:
  datasource:
    url: jdbc:postgresql://localhost:54321/abcbank
    username: postgres
    password: postgres

```

## API Root Endpoint
`localhost:8080/api/auth/signup`

```
{
    "username":"Fethi",
    "email":"sennfethi@gmail.com",
    "password":"123456"
}
```
`http://localhost:8080/api/auth/signin`

```
{
    "username":"Fethi",
    "password":"123456",
    "rememberMe":true
}
```
`http://localhost:8080/myAccount?id=1`