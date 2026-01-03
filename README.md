# UserRegistrationandLongwithJWT
# 🔐 Spring Boot JWT Authentication (HTML + REST API)

A complete authentication system built using **Spring Boot**, **Spring Security**, **JWT**, **JPA**, and **Thymeleaf**.  
This project supports **HTML-based login/registration** as well as **REST APIs (Postman tested)**.

---

## 🚀 Features

- ✅ User Registration (HTML + REST API)
- ✅ User Login (HTML + REST API)
- 🔐 JWT Token Generation
- 🔑 Password Encryption using BCrypt
- 🛡 Spring Security Configuration
- 📄 Thymeleaf Templates (Login, Register, Success)
- 🧪 Postman Tested APIs
- 🗄 MySQL Database Integration

---

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Security**
- **JWT (jjwt)**
- **Spring Data JPA**
- **MySQL**
- **Thymeleaf**
- **Maven**

---
## 📁 Project Structure
src/main/java
└── io.jwtusetologin.login
├── controller
│ └── AuthController.java
├── model
│ └── User.java
├── repository
│ └── UserRepository.java
├── service
│ └── UserService.java
├── security
│ ├── JwtUtil.java
│ └── SecurityConfig.java
└── LoginApplication.java
src/main/resources
├── templates
│ ├── login.html
│ ├── register.html
│ └── success.html
└── application.properties

Spring boot JWT
Postman 
Post: http://localhost:8080/api/register
{
  "username": "Vimal Chaudhary",
  "email": "chaudharyvimal410@gmail.com",
  "password": "1234"
}
Post http://localhost:8080/api/login
{
  "username": "Vimal Chaudhary",
  "password": "1234"
}
