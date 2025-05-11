# Student Service – School Vaccination Portal

This service handles all student-related operations in the School Vaccination Portal system. It is built with Spring Boot and exposes RESTful APIs secured with JWT authentication. Features include student CRUD, bulk CSV upload, and marking vaccination records.

---

## Features

- Add, update, delete, and fetch students
- Upload students in bulk via CSV file
- Mark student vaccination status
- Prevent duplicate vaccinations for the same drive
- Secure endpoints using JWT
- API documentation with Swagger

---

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security + JWT
- JPA + PostgreSQL (or H2)
- Maven
- Docker
- Kubernetes (Minikube)

---

## REST API Overview

| Method | Endpoint              | Description                       |
|--------|-----------------------|-----------------------------------|
| POST   | `/auth/login`         | Simulated login (admin/admin)     |
| GET    | `/students`           | Get all students                  |
| POST   | `/students`           | Add a student                     |
| DELETE | `/students/{id}`      | Delete a student by ID            |
| POST   | `/students/upload`    | Upload students via CSV           |
| POST   | `/students/vaccinate` | Mark a student as vaccinated      |

All endpoints except `/auth/login` require a valid JWT token in the request header:

