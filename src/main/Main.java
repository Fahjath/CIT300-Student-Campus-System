package main;

import java.util.Scanner;

import models.Student;
import linkedlist.StudentLinkedList;
import stack.Stack;
import queue.Queue;
import tree.StudentBST;
import hashing.StudentHashTable;
import graph.CampusGraph;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static StudentLinkedList studentList = new StudentLinkedList();
    private static Stack recentActions = new Stack(20);
    private static Queue serviceQueue = new Queue(20);
    private static StudentBST bst = new StudentBST();
    private static StudentHashTable hashTable = new StudentHashTable(20);
    private static CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    displayRecentAction();
                    break;

                case 8:
                    displayBST();
                    break;

                case 9:
                    searchUsingHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusConnection();
                    break;

                case 13:
                    removeCampusConnection();
                    break;

                case 14:
                    displayCampusConnections();
                    break;

                case 15:
                    traverseCampus();
                    break;

                case 16:
                    System.out.println("Exiting Student Campus System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 16);

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("      STUDENT CAMPUS SYSTEM");
        System.out.println("======================================");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records");
        System.out.println("5.  Add Service Request");
        System.out.println("6.  Process Service Request");
        System.out.println("7.  Display Recent Actions");
        System.out.println("8.  Display Students using BST");
        System.out.println("9.  Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection");
        System.out.println("13. Remove Campus Connection");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. BFS / DFS");
        System.out.println("16. Exit");
        System.out.println("======================================");
    }

    private static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt("Student ID: ");
        String name = readString("Name: ");
        String programme = readString("Programme: ");
        double marks = readDouble("Marks: ");

        Student student = new Student(id, name, programme, marks);

        if (studentList.addStudent(student)) {

            bst.insert(student);
            hashTable.insert(student);

            recentActions.push("Added student: " + id);

            System.out.println("Student added successfully.");

        } else {

            System.out.println("Student could not be added.");
            System.out.println("Student ID may already exist.");
        }
    }

    private static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        int id = readInt("Student ID: ");

        Student existing = studentList.findStudent(id);

        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readString("New Name: ");
        String programme = readString("New Programme: ");
        double marks = readDouble("New Marks: ");

        if (studentList.updateStudent(id, name, programme, marks)) {

            /*
             * The existing BST and Hash Table store Student object references,
             * so updating the Student object through the linked list also
             * updates the same Student object stored in those structures.
             */

            recentActions.push("Updated student: " + id);

            System.out.println("Student updated successfully.");

        } else {

            System.out.println("Student update failed.");
        }
    }

    private static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        int id = readInt("Student ID: ");

        Student student = studentList.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        /*
         * StudentLinkedList supports deletion, but the supplied BST and
         * HashTable classes do not provide delete methods.
         *
         * Therefore the menu demonstrates the required Linked List
         * deletion operation without pretending that BST/Hash deletion
         * is implemented.
         */

        if (studentList.deleteStudent(id)) {

            recentActions.push("Deleted student: " + id);

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student deletion failed.");
        }
    }

    private static void displayStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        studentList.displayStudents();
    }

    private static void addServiceRequest() {

        System.out.println("\n===== ADD SERVICE REQUEST =====");

        int id = readInt("Student ID: ");
        String request = readString("Service Request: ");

        String service = "Student ID: " + id + " - " + request;

        serviceQueue.enqueue(service);

        recentActions.push("Added service request for student: " + id);

        System.out.println("Service request added successfully.");
    }

    private static void processServiceRequest() {

        System.out.println("\n===== PROCESS SERVICE REQUEST =====");

        if (serviceQueue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        Object request = serviceQueue.dequeue();

        System.out.println("Processing request:");
        System.out.println(request);

        recentActions.push("Processed service request");
    }

    private static void displayRecentAction() {

        System.out.println("\n===== RECENT ACTION =====");

        if (recentActions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("Latest Action: " + recentActions.peek());
    }

    private static void displayBST() {

        System.out.println("\n===== STUDENTS USING BST =====");

        if (bst.isEmpty()) {
            System.out.println("BST is empty.");
            return;
        }

        bst.displayInOrder();
    }

    private static void searchUsingHashing() {

        System.out.println("\n===== HASH TABLE SEARCH =====");

        int id = readInt("Enter Student ID: ");

        Student student = hashTable.search(id);

        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void addCampusLocation() {

        System.out.println("\n===== ADD CAMPUS LOCATION =====");

        String location = readString("Location name: ");

        if (campusGraph.addLocation(location)) {
            System.out.println("Campus location added successfully.");
        } else {
            System.out.println("Location could not be added.");
            System.out.println("It may already exist.");
        }
    }

    private static void removeCampusLocation() {

        System.out.println("\n===== REMOVE CAMPUS LOCATION =====");

        String location = readString("Location name: ");

        if (campusGraph.removeLocation(location)) {
            System.out.println("Campus location removed successfully.");
        } else {
            System.out.println("Location not found.");
        }
    }

    private static void addCampusConnection() {

        System.out.println("\n===== ADD CAMPUS CONNECTION =====");

        String location1 = readString("First location: ");
        String location2 = readString("Second location: ");

        if (campusGraph.addConnection(location1, location2)) {
            System.out.println("Campus connection added successfully.");
        } else {
            System.out.println("Connection could not be added.");
            System.out.println("Check that both locations exist.");
        }
    }

    private static void removeCampusConnection() {

        System.out.println("\n===== REMOVE CAMPUS CONNECTION =====");

        String location1 = readString("First location: ");
        String location2 = readString("Second location: ");

        if (campusGraph.removeConnection(location1, location2)) {
            System.out.println("Campus connection removed successfully.");
        } else {
            System.out.println("Connection could not be removed.");
        }
    }

    private static void displayCampusConnections() {

        System.out.println("\n===== CAMPUS CONNECTIONS =====");

        campusGraph.displayConnections();
    }

    private static void traverseCampus() {

        System.out.println("\n===== CAMPUS TRAVERSAL =====");

        String startLocation = readString("Starting location: ");

        System.out.println("\nBFS Traversal:");
        campusGraph.bfs(startLocation);

        System.out.println("DFS Traversal:");
        campusGraph.dfs(startLocation);
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double value =
                        Double.parseDouble(scanner.nextLine().trim());

                if (value < 0 || value > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Invalid marks. Please enter a valid number.");
            }
        }
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}
