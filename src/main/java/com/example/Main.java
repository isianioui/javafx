
package com.example;

import java.util.List;



public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        Student student1 = new Student(1, "John Doe", "john.doe@example.com");
        studentDao.addStudent(student1);

        Student retrievedStudent = studentDao.getStudentById(1);
        if (retrievedStudent != null) {
            System.out.println("Retrieved Student: " + retrievedStudent);
        }

        student1.setName("John Smith");
        student1.setEmail("john.smith@example.com");
        studentDao.updateStudent(student1);

        List<Student> students = studentDao.getAllStudents();
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        studentDao.deleteStudent(1);

        Student deletedStudent = studentDao.getStudentById(1);
     
    }
}
