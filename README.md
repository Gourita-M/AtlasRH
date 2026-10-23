# AtlasRH

AtlasRH is a Spring Boot REST API for managing human resources data, with a focus on departments and employees. The project provides a simple backend for an HR system where departments can be created and employees can be registered and associated with a department.

## Overview

This application uses Java 17, Spring Boot, Spring Data JPA, PostgreSQL, and MapStruct to expose a clean REST interface for HR operations. It is designed to serve as a backend foundation for a company management or employee administration application.

## Features

- Manage departments
- Manage employees
- Associate each employee with a department
- Retrieve all departments and employees via REST APIs
- JPA persistence with PostgreSQL
- DTO-based responses for cleaner API contracts

## Tech Stack

- Java 17
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
- MapStruct

## Project Structure

```text
AtlasRH/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/atlasrh/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── mapper/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Prerequisites

Before running the project, make sure you have:

- Java 17+
- Maven 3.9+
- PostgreSQL installed and running
- A database named `atlasrhv1` (or update the credentials in the configuration)

## Configuration

The project configuration is defined in `src/main/resources/application.properties`.

```properties
spring.application.name=AtlasRH

spring.datasource.url=jdbc:postgresql://localhost:5432/atlasrhv1
spring.datasource.username=postgres
spring.datasource.password=1996

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

If your PostgreSQL setup is different, update the datasource URL, username, and password accordingly.

## Running the Application

### With Maven

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will start on the default Spring Boot port:

```text
http://localhost:8080
```

## API Endpoints

### Department endpoints

#### Get all departments

```http
GET /api/department
```

#### Create a department

```http
POST /api/department
Content-Type: application/json
```

Example body:

```json
{
  "name": "Engineering",
  "description": "Software and product engineering team"
}
```

### Employee endpoints

#### Get all employees

```http
GET /api/employee
```

#### Create an employee in a department

```http
POST /api/employee/{departmentId}
Content-Type: application/json
```

Example body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "jobTitle": "Senior Developer",
  "hireDate": "2024-01-15",
  "role": "MANAGER"
}
```

Example request:

```bash
curl -X POST http://localhost:8080/api/employee/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "jobTitle": "Senior Developer",
    "hireDate": "2024-01-15",
    "role": "MANAGER"
  }'
```

## Data Model

### Department

- `id`
- `name`
- `description`
- `employees`

### Employee

- `matricule`
- `firstName`
- `lastName`
- `email`
- `jobTitle`
- `hireDate`
- `role`
- `department`

Employee roles currently include:

- `RH_MANAGER`
- `MANAGER`

## Notes

This project is a solid backend foundation for an HR system and is currently focused on the core department/employee management flow. Some planned features, such as manager-based views and more advanced employee updates, are either not yet implemented or are still being expanded.

## License

This project is currently unlicensed and intended for learning and internal development use unless otherwise specified.

## Contributing

Contributions are welcome. If you want to improve the API, add validation, tests, or new endpoints, feel free to fork the project and submit a pull request.
