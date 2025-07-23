package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of Employee ");
		int number = scanner.nextInt();
		scanner.nextLine();

		Employee[] employee = new Employee[number];

		System.out.println("Entre Employee details ");
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the name of Employee ");
			String name = scanner.nextLine();

			System.out.println("Enter the Id of Employee ");
			int id = scanner.nextInt();

			System.out.println("Enter the Basic salary of Employee ");
			double basicSalary = scanner.nextDouble();

			employee[i] = new Employee(name, id, basicSalary);
			scanner.nextLine();
		}
		for (Employee emp : employee)
			System.out.println("Total salary: " +"of employee name "+ emp.name+ " : " + emp.generateSalarySlip());

	}
}








/*
 * 4. Employee Salary Slip Generator: - Define a class Employee with fields:
 * name, id, basicSalary. - Use a constructor to set these values. - Create a
 * method generateSalarySlip() which calculates:
 * 
 * > HRA = 20% of basic
 * 
 * > DA = 10% of basic
 * 
 * > Total salary = basic + HRA + DA
 * 
 * - Create 2 employee objects and print their salary slips.
 */