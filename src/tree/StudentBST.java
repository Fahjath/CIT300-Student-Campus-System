package tree;

import models.Student;

public class StudentBST {

    private class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    public boolean insert(Student student) {
        if (student == null) {
            return false;
        }

        if (root == null) {
            root = new Node(student);
            return true;
        }

        return insertNode(root, student);
    }

    private boolean insertNode(Node current, Student student) {
        int id = student.getStudentId();

        if (id == current.student.getStudentId()) {
            return false;
        }

        if (id < current.student.getStudentId()) {
            if (current.left == null) {
                current.left = new Node(student);
                return true;
            }
            return insertNode(current.left, student);
        }

        if (current.right == null) {
            current.right = new Node(student);
            return true;
        }

        return insertNode(current.right, student);
    }

    public Student search(int studentId) {
        Node current = root;

        while (current != null) {
            if (studentId == current.student.getStudentId()) {
                return current.student;
            }

            if (studentId < current.student.getStudentId()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public void displayInOrder() {
        displayInOrder(root);
    }

    private void displayInOrder(Node node) {
        if (node == null) {
            return;
        }

        displayInOrder(node.left);
        System.out.println(node.student);
        displayInOrder(node.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}