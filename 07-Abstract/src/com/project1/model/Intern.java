package com.project1.model;

public class Intern extends Employee {
	private double stipend;
	
	public Intern(String name , int id, double stipend){
		super(name, id);
		this.stipend = stipend;
	}
	@Override
	public void calculateSalary()  {
		double salary;
		salary = stipend;
		System.out.println(name+ ", Salary: "+ salary);
}
}

/*Create an abstract class Employee with fields name, id, and an abstract method
calculateSalary().
Subclasses:
 Developer: Salary = baseSalary + bonus
 Intern: Salary = stipend
In the main() method:
 Create an array of 2 Developer and 2 Intern objects.
 Loop through the array and print names with their salaries.
*/