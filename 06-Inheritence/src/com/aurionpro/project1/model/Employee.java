package com.aurionpro.project1.model;

public class Employee {
	private int employeeId ;
	private String name ;
	private double salary;
	private JobRole role;
	
	public Employee(int employeeId, String name, double salary, JobRole role) {
	    this.employeeId = employeeId;
	    this.name = name;
	    this.salary = salary;
	    this.role = role;
	}

	
	 public int getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(int employeeId) {
	        this.employeeId = employeeId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    public JobRole getRole() {
	        return role;
	    }
	    
	    public void setRole(JobRole role) {
	        this.role = role;
	    }
	    
	    //bonus 
	    public double calculateBonus() {
	        if (role == JobRole.MANAGER) {
	            return salary * 0.20;
	        } else if (role == JobRole.DEVELOPER || role == JobRole.DESIGNER) {
	            return salary * 0.15;
	        } else {
	            return salary * 0.10;
	        }
	    }
	}



/*Create a Java program to simulate an Employee Payroll System with the following requirements:
Define an enum JobRole with values: MANAGER, DEVELOPER, DESIGNER, TESTER, HR.

Create an Employee class with:
• employeeId (integer)
• name (String)
• salary (double)
• role (enum JobRole)

Implement:
•  A constructor to initialize all attributes.
•  Getters and setters for each attribute.

A method calculateBonus() that:
•  Returns 20% of salary if role is MANAGER.
•  Returns 15% if role is DEVELOPER or DESIGNER.
•  Returns 10% for other roles.

In the Payroll class, create an array of Employee objects (size 5).

Implement methods in Payroll to:
•  Add an employee to the array.
•  Display all employees with their salaries and bonuses.
•  Search employees by job role and display their details.

Write a main method to:
•  Create a Payroll object.
•  Add employees to the system.
•  Display all employees with their calculated bonuses.
•  Search employees by role and display their details*/

