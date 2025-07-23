package com.aurionpro.model;
/*Employee Salary Slip Generator:
- Define a class Employee with fields: name, id, basicSalary.
- Use a constructor to set these values.
- Create a method generateSalarySlip() which calculates:
 > HRA = 20% of basic
 > DA = 10% of basic
 > Total salary = basic + HRA + DA
- Create 2 employee objects and print their salary slips.*/
public class SalarySlipGenerator {

	 private String name;
	    private int id;
	    private double basicSalary;

	    // Constructor initialize 
	    public SalarySlipGenerator(String name, int id, double basicSalary) {
	        this.name = name;
	        this.id = id;
	        this.basicSalary = basicSalary;
	    }
	    public void generateSalarySlip() {
	        double hra = 0.20 * basicSalary;
	        double da = 0.10 * basicSalary;
	        double totalSalary = basicSalary + hra + da;

	        System.out.println("---------- Salary Slip ----------");
	        System.out.println("Employee ID   : " + id);
	        System.out.println("Employee Name : " + name);
	        System.out.println("Basic Salary  : " + basicSalary);
	        System.out.println("HRA (20%)     : " + hra);
	        System.out.println("DA (10%)      : " + da);
	        System.out.println("Total Salary  : " + totalSalary);
	        System.out.println("---------------------------------\n");
	    }
	}
