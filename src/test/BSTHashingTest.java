package test;

import hashing.StudentHashTable;
import models.Student;
import tree.StudentBST;

public class BSTHashingTest {

    public static void main(String[] args) {

        Student s1 = new Student(1001, "Kamal", "Computer Science", 75.5);
        Student s2 = new Student(1002, "Nimal", "Information Technology", 82.0);
        Student s3 = new Student(1003, "Saman", "Software Engineering", 68.5);

        // BST test
        StudentBST bst = new StudentBST();

        bst.insert(s1);
        bst.insert(s2);
        bst.insert(s3);

        System.out.println("BST Search:");
        Student bstResult = bst.search(1002);

        if (bstResult != null) {
            System.out.println(bstResult);
        } else {
            System.out.println("Student not found");
        }

        System.out.println("\nBST In-Order:");
        bst.displayInOrder();

        // Hash table test
        StudentHashTable hashTable = new StudentHashTable(10);

        hashTable.insert(s1);
        hashTable.insert(s2);
        hashTable.insert(s3);

        System.out.println("\nHash Table Search:");
        Student hashResult = hashTable.search(1003);

        if (hashResult != null) {
            System.out.println(hashResult);
        } else {
            System.out.println("Student not found");
        }
    }
}