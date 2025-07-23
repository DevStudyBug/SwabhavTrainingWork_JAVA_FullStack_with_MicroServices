package com.aurionpro.Student.model;

public class Student {
	int roll;
	String name;
	int marks;

	public Student(int roll, String name, int marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return String.format("%-10d %-15s %-5d", roll, name, marks);
	}
}
