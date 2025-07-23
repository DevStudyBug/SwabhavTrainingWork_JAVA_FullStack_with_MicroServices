package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Student;

public class StudentTest {
public static void main(String[] args) {
	Scanner scanner  = new Scanner(System.in);
	System.out.println("Enter the number of student : ");
	int numberofStudent = scanner.nextInt();
	
	Student[] students =new Student[numberofStudent]; 
	
	System.out.println("Enter Student details: ");
	for (int i = 0; i < numberofStudent; i++)
	{
	    System.out.print("Enter roll number: ");
	    int rollNumber = scanner.nextInt();
	    
	    scanner.nextLine();
	    System.out.print("Enter student name: ");
	    String studentName = scanner.nextLine();
	    
	    System.out.print("Enter cgpa: ");
	    double cgpa = scanner.nextDouble();
	    
	    students[i] = new Student(studentName, rollNumber, cgpa);
	}

	for (Student result : students) {
	    result.display();
	}
	}
}
