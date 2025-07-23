package com.aurionpro.model;

public class subclassSuperclass {
	public void Display() { // method override in subclass
		System.out.println("In parent class");
	}
	public void Display(String Hello) {  //method overloading 
		System.out.println("Hello"+Hello);
	}
}

