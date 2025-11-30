# Lab-Assignment-3

Student Management System
1. Object-Oriented Design

Student Class

Stores student details: rollNo, name, email, course, marks, grade.

Implements methods: inputDetails(), displayDetails(), calculateGrade().

Uses wrapper classes (Integer, Double) for autoboxing and type conversion.

2. Exception Handling

Try-Catch-Finally blocks used to handle runtime errors.

Validates input:

Marks must be in range 0–100.

Name, email, and course fields cannot be empty.

Custom Exception: StudentNotFoundException

Thrown when attempting to view a student that does not exist.

3. Multithreading

Loader Class implements Runnable

Simulates loading process when adding or saving student data.

Thread.sleep() used to create delay for responsiveness.

Improves user experience by simulating a “loading” animation.

4. Wrapper Classes

Use of Integer and Double:

Converts input strings to numeric types (Integer.valueOf, Double.valueOf).

Demonstrates autoboxing (primitive to object conversion).

5. Student Management Operations

StudentManager Class

Uses HashMap<Integer, Student> for storing student records.

Implements methods:

addStudent() – adds student to records.

viewStudent() – view single student, throws StudentNotFoundException if missing.

viewAllStudents() – displays all students.

6. Sample Data Demonstrated

Students added in code:

Roll No 101: Ankit, B.Tech, 85 → Grade B

Roll No 102: Riya, M.Tech, 92.5 → Grade A

Roll No 103: Karan, BCA, 77.5 → Grade B

Allows user to add a new student interactively.

7. Key Features Demonstrated

Robust input validation using exception handling.

Responsiveness using multithreading for simulated loading.

Autoboxing and data conversion with wrapper classes.

Custom exception for missing records.

Clear output with student grades automatically calculated.

8. Learning Outcomes

Implement try-catch-finally and custom exceptions.

Use multithreading (Runnable, Thread) to improve UI responsiveness.

Understand and apply wrapper classes and autoboxing.

Build a simple, robust, and interactive student management system.
