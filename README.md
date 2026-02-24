# Task Manager API 🛠️

A production-ready backend API for user authentication and personal task management, built with Java + Spring Boot.

> This project is designed to demonstrate clean backend architecture, secure authentication, and practical REST API design for portfolio and resume review.

---

## 🔗 Live Deployment

**Backend Base URL:** https://task-manager-api-5853.up.railway.app

**Full-Stack URL:** https://my-task-manager-frontend.netlify.app or https://quicktasktracker.org


### Quick Recruiter Links
- **Frontend Repository:** https://github.com/samf5853/task-manager-frontend
- **Backend Repository:** https://github.com/samf5853/Task-Manager-API

---

## 📌 Project Overview

Task Manager API is a secure REST backend where users can:
- Create an account and sign in with JWT authentication.
- Manage only their own tasks (user-scoped access control).
- Perform full CRUD operations on tasks.

This project reflects real backend engineering concerns including:
- Auth and authorization
- DTO-driven API responses
- Environment-variable-based configuration
- CORS setup for frontend integration

---

## ✨ Key Features

- 🔐 **JWT Authentication** (signup/signin)
- 👤 **User-scoped authorization** (data isolation per account)
- ✅ **Task CRUD endpoints**
- 🧩 **Role model foundation** for future permission expansion
- 🗄️ **Database persistence** with JPA/Hibernate
- 🌍 **Configurable CORS** for deployed frontend clients
- 🧼 **Structured request/response payloads (DTOs)**

---

## 🧱 Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot
- **Security:** Spring Security + JWT
- **ORM:** Spring Data JPA / Hibernate
- **Database:** MySQL (configured via environment variables)
- **Build Tool:** Maven

---

## 🏗️ Architecture Snapshot

```
Controller Layer
  -> handles HTTP requests/responses

Service Layer
  -> business logic (task ownership, operations)

Repository Layer
  -> persistence access via Spring Data JPA

Security Layer
  -> JWT filter, auth entrypoint, security config

Model + DTO Layer
  -> entities + request/response contracts
```

---

## 📁 Core Project Structure

```text
src/main/java/com/fostersolutions/taskmanager/
├── config/
├── controller/
├── models/
├── payload/
│   ├── request/
│   └── response/
├── repository/
├── security/
│   ├── jwt/
│   └── services/
└── TaskManagerApplication.java
```

---

## ⚙️ Local Setup

### 1) Prerequisites
- Java 17+
- Maven
- MySQL running locally

### 2) Configure Environment Variables

Use your shell, IDE run config, or `.env` loading approach to define:

```env
DB_URL=jdbc:mysql://localhost:3306/task_manager
DB_USER=mysql
DB_PASSWORD=yourpassword

JWT_SECRET=your-strong-secret-key
JWT_EXPIRATION=86400000

CORS_ALLOWED_ORIGINS=http://localhost:3000
```

### 3) Run the API

```bash
./mvnw spring-boot:run
```

API default URL:

```text
http://localhost:8080
```

---

## 📡 API Endpoints

### Authentication
- `POST /auth/signup`
- `POST /auth/signin`

### Tasks (JWT Required)
- `GET /api/tasks`
- `POST /api/tasks`
- `PUT /api/tasks/{id}`
- `DELETE /api/tasks/{id}`

### Health/Test
- `GET /api/test/all` (public test route)

---

## 🧪 Example API Usage

### Sign Up

```http
POST /auth/signup
Content-Type: application/json

{
  "username": "sam",
  "email": "sam@example.com",
  "password": "password123",
  "role": ["user"]
}
```

### Sign In

```http
POST /auth/signin
Content-Type: application/json

{
  "username": "sam",
  "password": "password123"
}
```

### Create Task

```http
POST /api/tasks
Authorization: Bearer <jwt_token>
Content-Type: application/json

{
  "title": "Finish portfolio README",
  "description": "Add polished project documentation",
  "completed": false
}
```

---

## 🔒 Security Notes

- Passwords are encoded before persistence.
- JWT is validated on protected routes using a security filter.
- Task access is scoped to the authenticated user.
- CORS is centrally configured using `CORS_ALLOWED_ORIGINS`.

---

## 🚀 Deployment Notes

When deploying this backend, configure the same environment variables in your hosting platform:

- `DB_URL`
- `DB_USER`
- `DB_PASSWORD`
- `JWT_SECRET`
- `JWT_EXPIRATION`
- `CORS_ALLOWED_ORIGINS`

---

## 👤 Portfolio / Resume Context

This project demonstrates:
- Building secure REST APIs with Spring Boot
- Implementing token-based authentication (JWT)
- Designing maintainable backend layers
- Managing relational data with JPA/Hibernate
- Preparing an application for cloud deployment

If you’re reviewing this for hiring purposes, this repository showcases practical backend fundamentals used in production-grade services.

---

## 📬 Contact

`LinkedIn` `www.linkedin.com/in/samuel-foster-jr`

`Email` `samf5853@gmail.com`
