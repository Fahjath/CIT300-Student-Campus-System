package linkedlist;

import models.Student;

public class StudentLinkedList {

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    // Add a new student
    public boolean addStudent(Student student) {

        if (student == null) {
            return false;
        }

        if (findStudent(student.getStudentId()) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return true;
    }

    // Find a student by Student ID
    public Student findStudent(int studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId() == studentId) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update student information
    public boolean updateStudent(
            int studentId,
            String name,
            String programme,
            double marks) {

        Student student = findStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    // Delete a student
    public boolean deleteStudent(int studentId) {

        if (head == null) {
            return false;
        }

        // If the student is the first node
        if (head.student.getStudentId() == studentId) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId() == studentId) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all students
    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    // Check whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}