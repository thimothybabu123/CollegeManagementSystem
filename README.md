# 🎓 College Management System

A Spring Boot REST API that manages student enrollment, course allocation, and instructor-department relationships in a college. The system allows CRUD operations on students and handles their associations with courses, instructors, and departments using a PostgreSQL database.

---

## 🚀 Tech Stack

- **Backend:** Spring Boot  
- **Database:** PostgreSQL  
- **ORM:** Spring Data JPA (Hibernate)  
- **Lombok:** For reducing boilerplate code  
- **Maven:** For dependency management and build

---

## 🧠 Entity Relationships

- 📚 **Student → Course** : Many-to-One  
  ➤ Many students can enroll in one course.

- 👨‍🏫 **Course → Instructor** : One-to-One  
  ➤ Each course is taught by one instructor.

- 🏛 **Department → Instructor** : One-to-Many (Bidirectional)  
  ➤ A department can have multiple instructors.

---

## ✅ Features

- Add new students and enroll them into courses  
- Get all students enrolled in a specific course  
- Update student details by email  
- Delete a student using their email  
- Validation and exception handling with custom exceptions  
- Database referential integrity maintained using foreign key constraints  

---

## 🧪 API Endpoints

### ➕ Add Student
```http
POST /college/add-student
```
**Request Body:**
```json
{
  "name": "Tim Cook",
  "email": "timcook@gmail.com",
  "coursesDTO": {
    "courseId": 1
  }
}
```
**Response:**
```json
{
  "message": "Student added successfully",
  "status": "Success"
}
```

---

### 📋 Get Students by Course
```http
GET /college/get-students/{courseId}
```
Returns a list of students enrolled in the course with the specified ID.

---

### 📝 Update Student
```http
PUT /college/updateStudent/{email}
```
**Request Body:**
```json
{
  "name": "Elon Musk",
  "email": "elon@gmail.com",
  "coursesDTO": {
    "courseId": 2
  }
}
```
**Response:**
```json
{
  "message": "Student updated successfully",
  "status": "Success"
}
```

---

### ❌ Delete Student
```http
DELETE /college/deleteStudent/{email}
```
Deletes a student by their email address.

---

## ⚠️ Constraints

- You cannot delete a course if any student is still enrolled in it (foreign key constraint).
- Unique constraint is assumed on student email.
- Proper error handling via custom exception class (`CollegeManagementSystemException`).

---

## 🛠️ Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/college-management-system.git
cd college-management-system
```

### 2. Set Up the Database
Create a PostgreSQL database:
```sql
CREATE DATABASE college_db;
```

Update `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/college_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

---

## 🧪 Sample User Stories

1. As an admin, I want to add a student with course details so that they can be enrolled.
2. As an admin, I want to fetch all students enrolled in a course so that I can view their details.
3. As an admin, I want to update student information using their email.
4. As an admin, I want to delete a student by email to remove them from the system.
5. As an instructor, I want to view my assigned course details.
6. As a department head, I want to see all instructors under my department.
7. As a developer, I want proper exception handling so that users see helpful error messages.
8. As an admin, I want to ensure that deleting a course is not possible if students are enrolled in it.

---

## 🔒 Sample Validation/Error

```json
{
  "timestamp": "2025-07-17T08:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Student with email 'unknown@gmail.com' not found",
  "path": "/college/deleteStudent/unknown@gmail.com"
}
```

---

## 📬 Postman / Swagger

You can test the APIs using Postman or integrate Swagger by adding the following dependency:

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version>
</dependency>
```

Then access docs at:  
```bash
http://localhost:8080/swagger-ui/index.html
```

---

## 👤 Author

Developed by [Thimothi Babu Ramagalla](https://github.com/thimothybabu123) – for academic and learning purposes.

---

## 📝 License

This project is licensed under the MIT License – see the LICENSE file for details.
