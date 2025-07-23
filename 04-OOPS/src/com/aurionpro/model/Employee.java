package com.aurionpro.model;

/*4. Employee Salary Slip Generator:

- Define a class Employee with fields: name, id, basicSalary.

- Use a constructor to set these values.

- Create a method generateSalarySlip() which calculates:

> HRA = 20% of basic

> DA = 10% of basic

> Total salary = basic + HRA + DA

- Create 2 employee objects and print their salary slips.*/
public class Employee {
	public String name;
	int id;
	double basicSalary;

	public Employee(String name, int id, double basicSalary) {
		this.name = name;
		this.id = id;
		this.basicSalary = basicSalary;

	}

	public double generateSalarySlip() {
		double HRA = 20 % basicSalary;
		double DA = 10 % basicSalary;
		double totalSalary = basicSalary + HRA + DA;
		return totalSalary;
	}
}
