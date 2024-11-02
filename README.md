# StudentDataManagementAPIwithSpringBoot_GDG_MIT_

This project is a simple RESTful API for Student Management System, built using Spring Boot. It supports basic CRUD operations with in-memory storage using a HashMap. It provides functionality to retreive all students, filter based on specific criteria, update records delete students, and retrieve top N students based on marks.

## Prerequistes:
Java 17 or later
Maven for dependency managemenet and build

## Getting started:
1. Clone the repository (files are in master branch)
   ```
   git clone -b master https://github.com/jananialagar4/StudentDataManagementAPIwithSpringBoot_GDG_MIT_.git
   
   cd student-management-api
   ```
3. Build the project
   ```
   mvm clean install
   ```
5. Run the application
   ```
   mvn spring-boot:run
   ```
7. Access swagger UI to test the API at
   ```
   http://localhost:8080/swagger-ui.html
   ```

## Endpoints:
- POST/students - creates new student with auto-incremeneted Id
- GET/students - retrieves all students or filter based on critieria (course, feesPaid, minMarks, maxMarks)
- GET/students/{id} - retrieve a specific student by Id
- PUT/students/{id} - update details of an existing student by Id
- DELETE/students/{id} - delete a student by Id
- GET/students/top{n} - retrieve top N students based on marks





