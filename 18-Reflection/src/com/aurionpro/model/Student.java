package com.aurionpro.model;

public class Student {
	private String name;
	int rollNumber;
	Double cgpa;
	public final int marks = 70;
	
	public  Student() {
		
	}
	public Student(String name, int rollNumber, Double cgpa) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.cgpa = cgpa;
	}
	
	private  void Greet()
	{
		System.out.println("Hello Welcome!");
		
	}
	public double result(double cgpa) {
		return cgpa;
	}
}
