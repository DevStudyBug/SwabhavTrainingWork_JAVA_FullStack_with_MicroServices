package com.project1.model;

public abstract class Employee {
	public String name;
	private int id;
	
	Employee(String name , int id ){
		this.name = name ;
		this.id = id;
	}
	public abstract void calculateSalary() ;
}

/*Q1. Employee Salary Calculator
Create an abstract class Employee with fields name, id, and an abstract method
calculateSalary().
Subclasses:
 Developer: Salary = baseSalary + bonus
 Intern: Salary = stipend
In the main() method:
 Create an array of 2 Developer and 2 Intern objects.
 Loop through the array and print names with their salaries.*/