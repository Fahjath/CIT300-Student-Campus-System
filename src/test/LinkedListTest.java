package test;

import linkedlist.StudentLinkedList;
import models.Student;

public class LinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList studentList = new StudentLinkedList();

        // Add students
        studentList.addStudent(
                new Student(1001, "Kamal", "Computer Science", 78.5));

        studentList.addStudent(
                new Student(1002, "Nimal", "Information Technology", 85.0));

        studentList.addStudent(
                new Student(1003, "Saman", "Software Engineering", 67.5));

        System.out.println("===== ALL STUDENTS =====");
        studentList.displayStudents();

        // Search student
        System.out.println("\n===== SEARCH STUDENT =====");

        Student foundStudent = studentList.findStudent(1002);

        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        // Update student
        System.out.println("\n===== UPDATE STUDENT =====");

        boolean updated = studentList.updateStudent(
                1002,
                "Nimal Perera",
                "Information Technology",
                90.0);

        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }

        studentList.displayStudents();

        // Delete student
        System.out.println("\n===== DELETE STUDENT =====");

        boolean deleted = studentList.deleteStudent(1001);

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }

        studentList.displayStudents();

        // Duplicate ID test
        System.out.println("\n===== DUPLICATE ID TEST =====");

        boolean added = studentList.addStudent(
                new Student(1002, "Another Student", "Computer Science", 70.0));

        if (added) {
            System.out.println("Student added.");
        } else {
            System.out.println("Duplicate Student ID. Student was not added.");
        }
    }
}