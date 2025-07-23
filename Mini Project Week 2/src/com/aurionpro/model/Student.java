package com.aurionpro.model;

public abstract class Student {
	String name;
	int rollNumber;
	String stream;
	
	public Student(String name, int rollNumber, String stream) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.stream = stream;
		
	}
	public abstract void calculatePerformance();
	public abstract void displayPerformance();
	public abstract void displayPerformance(boolean detailed);
	public abstract void displayPerformance(String format);

	public void displayInfo() {
		System.out.println("\n------Student Performance Management System-----");
		System.out.println("\nName : " + name +" | Roll No: " + rollNumber+ " | Stream: " + stream );
	}
	
	 public String getGrade(float average) {  
	        if (average > 90)
	            return "A";
	        else if (average > 70)
	            return "B";
	        else if (average > 50)
	            return "C";
	        else
	            return "F";
	    }
}





/*
Project Title:

"Student Performance Management System"

Problem Statement:

Design and implement a Java-based Student Performance Management System that models different types of students (e.g., ScienceStudent, CommerceStudent, ArtsStudent) using inheritance and abstract classes.
Each student must be able to calculate their performance (percentage or grade) using customized logic via method overriding. The system should allow different ways of displaying student performance using method overloading. All student objects should be stored and processed using arrays, not collections.

Objective:

To evaluate student performance based on their stream (science, commerce, etc.) and their individual subject marks. The system must provide:

Flexible performance calculation using polymorphism
Clear structure using abstract classes and inheritance
Multiple display formats using overloading
Arrays to store and process multiple students
Key Requirements (Feature Breakdown):

Abstract Class student

Fields: name, rollNumber, stream
Abstract method: calculatePerformance()
Concrete method: displayInfo() – displays basic info
Subclasses of Student

ScienceStudent → marks in Physics, Chemistry, Math
CommerceStudent → marks in Accounts, Business Studies, Economics
ArtsStudent → marks in History, Political Science, Sociology
Each class overrides calculatePerformance() to compute average and grade
3. Method Overloading

Add overloaded methods in student or another utility class:
displayPerformance() – default print
displayPerformance(boolean detailed) – shows subject-wise marks + average
displayPerformance(String format) – shows as percentage or grade
4. Array Usage

Use a fixed size student[] array to store multiple students (e.g., 5 students)
Loop over the array to display each student's info and performance
Expected Output Example:

yaml
Name : Ravi | Stream: Science | Roll No: 101
Subjects: Physics:80, Chemistry:75, Math:90
Performance (Avg): 85.0
Grade: A
yaml
Name : Anjali | Stream: Commerce | Roll No: 102
Subjects: Accounts:75, Business:78, Economics:80
Performance: 77.6 | Grade: B */