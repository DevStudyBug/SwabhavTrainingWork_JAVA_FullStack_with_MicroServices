package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.SalarySlipGenerator;

public class SalarySlipGeneratorTest {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        SalarySlipGenerator[] employees = new SalarySlipGenerator[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();

            System.out.print("Enter Basic Salary: ");
            double basicSalary = scanner.nextDouble();
            scanner.nextLine(); 

            employees [i] = new SalarySlipGenerator(name, id, basicSalary);
        }

        System.out.println("\n--- Salary Slips ---");
        for (SalarySlipGenerator emp : employees) {
            emp.generateSalarySlip();
        }

        scanner.close();
    }
}

/*Employee Salary Slip Generator:
- Define a class Employee with fields: name, id, basicSalary.
- Use a constructor to set these values.
- Create a method generateSalarySlip() which calculates:
 > HRA = 20% of basic
 > DA = 10% of basic
 > Total salary = basic + HRA + DA
- Create 2 employee objects and print their salary slips.*/