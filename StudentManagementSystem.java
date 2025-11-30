import java.util.*;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class Student {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;
    private char grade;

    public Student() {}

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public void inputDetails(Scanner sc) {
        try {
            System.out.print("Enter Roll No (Integer): ");
            rollNo = Integer.valueOf(sc.nextLine());
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

            System.out.print("Enter Email: ");
            email = sc.nextLine();
            if (email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");

            System.out.print("Enter Course: ");
            course = sc.nextLine();
            if (course.isEmpty()) throw new IllegalArgumentException("Course cannot be empty");

            System.out.print("Enter Marks: ");
            marks = Double.valueOf(sc.nextLine());
            if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be 0-100");

            Thread loader = new Thread(new Loader());
            loader.start();
            loader.join();
            calculateGrade();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            inputDetails(sc);
        } finally {
        }
    }

    private void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 50) grade = 'C';
        else grade = 'D';
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }
}

class Loader implements Runnable {
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted");
        }
    }
}

class StudentManager {
    private Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student s) {
        students.put(s.getRollNo(), s);
    }

    public void viewStudent(Integer rollNo) throws StudentNotFoundException {
        Student s = students.get(rollNo);
        if (s == null) throw new StudentNotFoundException("Student with Roll No " + rollNo + " not found");
        s.displayDetails();
    }

    public void viewAllStudents() {
        for (Student s : students.values()) {
            s.displayDetails();
            System.out.println();
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        Student s1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech", 85.0);
        Student s2 = new Student(102, "Riya", "riya@mail.com", "M.Tech", 92.5);
        Student s3 = new Student(103, "Karan", "karan@mail.com", "BCA", 77.5);

        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);

        System.out.println("Viewing All Students:\n");
        manager.viewAllStudents();

        System.out.println("Enter details for a new student:");
        Student newStudent = new Student();
        newStudent.inputDetails(sc);
        manager.addStudent(newStudent);

        System.out.println("\nDisplaying newly added student:");
        try {
            manager.viewStudent(newStudent.getRollNo());
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProgram execution completed.");
    }
}
