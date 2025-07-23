package com.aurionpro.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int marks;

    // Properly closed constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // toString method for readable output
    @Override
    public String toString() {
        return name + " - " + marks;
    }

    // main method inside Student class
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Anshika", 85),
            new Student("Ravi", 92),
            new Student("Meena", 78),
            new Student("Rahul", 59),
            new Student("Priya", 45)
        );

        // Filter: Students who scored 60 or above
        System.out.println("Students who scored 60 or above:");
        students.stream()
                .filter(s -> s.marks >= 60)
                .forEach(System.out::println);

        // 3. Find the student who scored the highest marks
        Student topStudent = students.stream()
            .max(Comparator.comparingInt(s -> s.marks))
            .get();

        System.out.println("Top student: " + topStudent.name + " with marks: " + topStudent.marks);

        // Sort and print
        System.out.println("\nStudents sorted by marks (ascending):");
        students.stream()
                .sorted(Comparator.comparingInt(s -> s.marks))
                .forEach(System.out::println);
    }
}
