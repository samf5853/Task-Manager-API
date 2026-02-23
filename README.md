# Task-Manager-API 🛠️

A secure REST API for managing personal tasks with JWT authentication and user-scoped access.  
Built with Spring Boot, Spring Security, JPA/Hibernate, and PostgreSQL.

## ✨ Features

- 🔐 JWT Authentication (Signup / Signin)
- 👤 User-scoped data (users can only access their own tasks)
- ✅ Task CRUD (Create, Read, Update, Delete)
- 🧩 Role-based foundation (extensible)
- 🗄️ PostgreSQL (local & production via env vars)
- 🧼 DTO responses (no sensitive data exposure)
- 🌍 CORS configured for frontend integration

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Security (JWT)
- JPA / Hibernate
- MySQL
- Maven

## 🚀 Getting Started (Local)

### Prerequisites
- Java 17+
- Maven
- MySQL running locally

### Environment Variables

Create a `.env` or set these in your IDE:

```env
DB_URL=jdbc:mysql://localhost:3306/task_manager
DB_USER=mysql
DB_PASSWORD=yourpassword

JWT_SECRET=your-secret-key
JWT_EXPIRATION=86400000 
```

#### Run
````bash
mvn spring-boot-run
````
API runs at:
````
http://localhost:8080
````
### 📡 API Endpoints
#### Auth

`POST /auth/signup`

`POST /auth/signin`

#### Tasks (JWT required)

`GET /api/tasks`

`POST /api/tasks`

`PUT /api/tasks/{id}`

`DELETE /api/tasks/{id}`

### 🌐 Frontend

👉 Frontend repo: https://github.com/samf5853/task-manager-frontend