package com.aurionpro.model;

	public class StudentDemo {
	    public static void changeName(Student s) {
	        s.name = "Anjali";
	        s = new Student();
	        s.name = "Riya";
	    }

	    public static void main(String[] args) {
	        Student s1 = new Student();
	        s1.name = "Amit";
	        System.out.println("Name: " + s1.name); 
	        changeName(s1); //override
	        System.out.println("Name: " + s1.name); // original value also  change when u create new object
	    }
	}

