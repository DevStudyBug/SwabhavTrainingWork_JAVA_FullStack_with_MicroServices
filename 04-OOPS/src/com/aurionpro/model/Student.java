package com.aurionpro.model;
/*Student Management System:
Create a Student class with private fields: name, rollNo, and marks.
Use getters and setters for each field.
In the setter for marks, ensure the value is between 0 and 100.
Create multiple student objects and display their data using getters.*/

public class Student {
	String name;
	private int rollNo;
	private int marks;
	public Student() {
		
	}
	public String getName() {
		return name;
	}
	public int getrollNo() {
		return rollNo;
		
	}
	public int getmarks() {
		
		return marks;
	}
	public void setname(String name) {
		this.name= name ;
	}
	public void setrollNo(int rollNo) {
		this.rollNo = rollNo ;
	}
	public void setmarks(int marks) {
	
		if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Please enter marks between 0 and 100");
        }
		
	}
//	public void display() {
//		System.out.println("Name: "+ name + " Roll Number: "+ rollNo+ "marks :"+ marks);
//	}
	public String toString() {
        return "Student { name='" + name + "', roll=" + rollNo + ", Mark=" +marks  + " }";
    }
}
