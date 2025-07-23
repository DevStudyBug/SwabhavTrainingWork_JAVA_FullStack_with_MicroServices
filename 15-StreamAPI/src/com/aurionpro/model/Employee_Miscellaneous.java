package com.aurionpro.model;

import java.time.LocalDate;

public class Employee_Miscellaneous {
	String name;
	public double salary;
	public LocalDate joiningDate;
	public String gender;
	public Employee_Miscellaneous(String name, double salary,LocalDate joiningDate, String gender) {
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee_Miscellaneous [name=" + name + ", salary=" + salary + ", joiningDate=" + joiningDate
				+ ", gender=" + gender + "]";
	}
	
}

/*Miscellaneous:
Create class Employee with name, salary, joiningDate and gender.
1. Find the employee who has maximum salary.
2. Find the employee who has second highest salary.
3. Find the employee who is most senior based on joining date.
4. count the employee based on gender.
*/