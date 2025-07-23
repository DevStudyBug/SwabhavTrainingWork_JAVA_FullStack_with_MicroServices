package com.aurionpro.model;

import java.io.Serializable;

public class Student implements Serializable {
	String name;
	int rollnumber;
	public Student(String name, int rollnumber) {

		this.name = name;
		this.rollnumber = rollnumber;
	}
	
	public void display() {
		System.out.println("Name: "+ name + ", Roll number: " + rollnumber);
	}
	
}
