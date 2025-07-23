package com.aurionpro.test;

import com.aurionpro.model.Employee;
import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[5];

        // Step 1: Take input
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            System.out.print("Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Employee Department: ");
            String dept = scanner.nextLine();

            System.out.print("Employee Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // clear buffer

            employees[i] = new Employee(id, name, dept, salary);
        }

        // Step 2: Find employee with lowest salary
        Employee lowest = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].empSalary < lowest.empSalary) {
                lowest = employees[i];
            }
        }
        System.out.println("\nEmployee with lowest salary:");
        lowest.display();

        // Step 3: Employees in IT department
        System.out.println("\nEmployees in IT Department:");
        boolean foundIT = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].empDepartment.equalsIgnoreCase("IT")) {
                employees[i].display();
                foundIT = true;
            }
        }
        if (!foundIT) {
            System.out.println("No employees in IT department.");
        }

        // Step 4: Total salary expense
        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            total += employees[i].empSalary;
        }
        System.out.println("\nTotal salary expense for company: ₹" + total);
    }
}
