package com.aurionpro.test;
//1. Student Profile Initialization:
//- Create a Student class with fields: name, rollNo, and course.
//- Use a parameterized constructor to initialize these fields.
//- Add a method displayDetails() to print student information.
//- Create 3 student objects with different data and call the method.

import java.util.Scanner;
import com.aurionpro.model.StudentProfile;
public class StudentPofileTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	    StudentProfile[] students = new StudentProfile[3]; 

	    for (int i = 0; i < 3; i++) {
	        students[i] = new StudentProfile();
	        System.out.println("Enter details for student " + (i + 1));
	        System.out.print("Enter student name: ");
	        String name = scanner.nextLine();
	        students[i].setname(name);        
	        System.out.print("Enter roll number: ");
	        int rollNo = scanner.nextInt();
	        students[i].setrollNo(rollNo);
	        scanner.nextLine();     
	        System.out.print("Enter course: ");
	        String course = scanner.nextLine();
	        students[i].setcourse(course);
	    }
	    System.out.println("\n--- Student Details ---");
	    for (StudentProfile std : students) {
	    	std.display(); 
	    }
	    scanner.close();
	} 
}


/*
import java.util.Scanner;
public class StdProfileTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StdProfile[] students = new StdProfile[3];
		for(int i =0;i<3;i++) {
			System.out.println("Enter Name of student :");
			String name = scanner.nextLine();
			System.out.println("Enter Roll number :");
			int rollNo = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter course :");
			String course = scanner.nextLine();
			students[i]= new StdProfile(name,rollNo,course);			
		}
		System.out.println("Course details ");
		for(StdProfile std : students) {
			std.display();
		}
		scanner.close();
	}	
}*/
