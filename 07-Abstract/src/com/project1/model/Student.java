package com.project1.model;

public abstract class Student {
	int rollNumber;
	String name;
	
	public Student(int rollNumber, String name) {
		this.rollNumber=rollNumber;
		this.name=name;
	}
	
	public abstract void CalculateGrade();

}

//Q3. Exam Grading System
//Create an abstract class Student with fields rollNumber, name, and an abstract method
//calculateGrade().
//Subclasses:
// ScienceStudent: average of 3 marks (physics, chemistry, maths)
// CommerceStudent: average of 3 marks (accounts, economics, business)
//In the main() method, allow input of marks for two students of each type and display their
//average and grade (A, B, C, etc.).