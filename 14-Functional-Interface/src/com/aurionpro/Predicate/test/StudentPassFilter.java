package com.aurionpro.Predicate.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Student{
	String name;
	int marks;
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
}

public class StudentPassFilter {
	public static void main(String[] args) {
		Predicate<Student> isPass = student-> (student.marks >=40);
		
		List<Student> students = Arrays.asList(
				new Student("Anshika", 95),
                new Student("Alok", 25),
                new Student("Amit", 30),
                new Student("Dev", 35),
                new Student("Sheetal", 90)
				); 
		System.out.println("Passing Students : ");
		for (Student student : students) {
            if (isPass.test(student)) {
                System.out.println(student.name + " - Marks: " + student.marks);
            }
            
		}
		
		System.out.println("\nFailing Students:");
        for (Student student : students) {
            if (!isPass.test(student)) {
                System.out.println(student.name + " - Marks: " + student.marks);
            }
        }
	}
}

//3. Student Pass Filter
//Given a Student class with name and marks, use a Predicate<Student> to check if marks
//are ≥ 40.
//Task: Print only passing students from a list of 5