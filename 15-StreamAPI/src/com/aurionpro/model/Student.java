package com.aurionpro.model;

public class Student {
	public String name;
	public int rollnumber;
	public double cgpa;

	public Student(String name, int rollnumber, double cgpa) {
		this.name = name;
		this.rollnumber = rollnumber;
		this.cgpa = cgpa;
	}

//	public double getcgpa() {
//		return cgpa;
//	}

//	public int getrollnumber() {
//		return rollnumber;
//	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollnumber=" + rollnumber + ", cgpa=" + cgpa + "]";
	}

}
//Given a list of Student objects, sort them by marks in ascending order, and print the sorted list.
