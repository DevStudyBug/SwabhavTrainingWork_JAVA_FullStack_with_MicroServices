package com.aurionpro.model;

public class Student {
	String name;
	int rollnumber;
	double cgpa;

	public Student(String name ,int rollnumber, double cgpa ) {
	this.name = name;
	this.rollnumber = rollnumber;
	this.cgpa = cgpa;
	
 }
	public void display() {
		System.out.println("name : "+ name + " roll number : "+ rollnumber + " cgpa : "+ cgpa);
		System.out.println("-------------------------------------------------------------");
	}
}
