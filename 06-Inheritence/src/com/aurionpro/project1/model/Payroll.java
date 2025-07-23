package com.aurionpro.project1.model;

public class Payroll {
	 Employee[] employees = new Employee[5];
	 
	    int count = 0;
	    public void addEmployee(Employee employee) {
	        if (count < employees.length) {
	            employees[count] = employee;
	            count++;
	        } else {
	            System.out.println("Cannot add more employees. Payroll is full.");
	            System.out.println("Total employees in payroll: " + count +"\n");
	        }
	    }

	    public void displayAllEmployees() {
	        System.out.println("Employee Details");
	        System.out.println("-------------------------------------------------------------");
	        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "ID", "Name", "Role", "Salary", "Bonus");
	        System.out.println("-------------------------------------------------------------");

	        for (int i = 0; i < count; i++) {
	            Employee e = employees[i];
	            System.out.printf("%-10d %-10s %-10s %-10.2f %-10.2f\n", e.getEmployeeId(), e.getName(), e.getRole(), e.getSalary(), e.calculateBonus());
	        }
	    }


	    public void searchByRole(JobRole role) {
	    	
	        System.out.println("\n--- Employees with Role: " + role + " ---");
	        int matchCount = 0;
	        for (int i = 0; i < count; i++) {
	            if (employees[i].getRole() == role) {
	                Employee e = employees[i];
	                System.out.println("ID: " + e.getEmployeeId()
	                        + ", Name: " + e.getName()
	                        + ", Salary: " + e.getSalary()
	                        + ", Bonus: " + e.calculateBonus());
	                matchCount++;
	            }
	        }
	        if (matchCount == 0) {
	            System.out.println("No employees found with role: " + role);
	        }
	    }
	}
