package hashing;

import models.Student;

public class StudentHashTable {

    private Student[] table;
    private int size;

    public StudentHashTable(int capacity) {
        table = new Student[capacity];
        size = 0;
    }

    private int hash(int studentId) {
        return Math.abs(studentId) % table.length;
    }

    public boolean insert(Student student) {
        if (student == null || size == table.length) {
            return false;
        }

        int index = hash(student.getStudentId());

        for (int i = 0; i < table.length; i++) {
            int position = (index + i) % table.length;

            if (table[position] == null) {
                table[position] = student;
                size++;
                return true;
            }

            if (table[position].getStudentId() == student.getStudentId()) {
                return false;
            }
        }

        return false;
    }

    public Student search(int studentId) {
        int index = hash(studentId);

        for (int i = 0; i < table.length; i++) {
            int position = (index + i) % table.length;

            if (table[position] == null) {
                return null;
            }

            if (table[position].getStudentId() == studentId) {
                return table[position];
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
