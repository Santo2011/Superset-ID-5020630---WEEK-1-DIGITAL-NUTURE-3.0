package com.mycompany.mvcpatternexample;

import java.util.Scanner;

// Step 2: Define Model Class
class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
    
    public void setName(String name) { this.name = name; }
    public void setGrade(String grade) { this.grade = grade; }
}

// Step 3: Define View Class
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Step 4: Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test the MVC Implementation
public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = new Student("1", "John Doe", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter 1 to change student name, 2 to change student grade, 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter new student name:");
                    String newName = scanner.nextLine();
                    controller.setStudentName(newName);
                    break;
                case 2:
                    System.out.println("Enter new student grade:");
                    String newGrade = scanner.nextLine();
                    controller.setStudentGrade(newGrade);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            controller.updateView();
        }

        scanner.close();
    }
}
