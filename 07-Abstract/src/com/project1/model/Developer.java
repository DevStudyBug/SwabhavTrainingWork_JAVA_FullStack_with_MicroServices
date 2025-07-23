package com.project1.model;

public class Developer extends Employee{
	
private double baseSalary , bonus;

public Developer(String name , int id, double baseSalary , double bonus) {
	super(name, id);
	this.baseSalary= baseSalary;
	this.bonus = bonus;
}
@Override
public void calculateSalary()  {
	double salary;
	salary = baseSalary + bonus;
	System.out.println(name+ ", Salary: "+ salary);
}



}
//*Q1. Employee Salary Calculator
//Create an abstract class Employee with fields name, id, and an abstract method
//calculateSalary().
//Subclasses:
// Developer: Salary = baseSalary + bonus
// Intern: Salary = stipend
//In the main() method:
// Create an array of 2 Developer and 2 Intern objects.
// Loop through the array and print names with their salaries.