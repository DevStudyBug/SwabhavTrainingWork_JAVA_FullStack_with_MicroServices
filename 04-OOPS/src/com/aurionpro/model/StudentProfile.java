package com.aurionpro.model;
//1. Student Profile Initialization:
//- Create a Student class with fields: name, rollNo, and course.
//- Use a parameterized constructor to initialize these fields.
//- Add a method displayDetails() to print student information.
//- Create 3 student objects with different data and call the method.
public class StudentProfile {
	private String name;
	private int rollNo;
	private String course;
	
	public String getName() {
		return name;  
	}
	public int getrollNo() {
		return rollNo;
	}
	public String getcourse() {
		return course;
	}

	public void setname(String name) {
		this.name= name ;
	}
	public void setrollNo(int rollNo) {
		this.rollNo = rollNo ;
	}
	public void setcourse(String course) {
		this.course= course ;
	}
	
	public void display() {
		
	System.out.println("Name: "+ name + " Roll Number: "+ rollNo+ " course : "+ course);
}	
}

/*package com.aurionpro.models;

public class StdProfile {
	String name;
	int rollNo;
	String course;
	
	public StdProfile(String name, int rollNo, String course) {
		this.name=name;
		this.rollNo=rollNo;
		this.course=course;
	}
	public void display() {
		System.out.println("Student Name :"+name);
		System.out.println("Roll No. :"+rollNo);
		System.out.println("Course name :"+course);
	}
}*/
