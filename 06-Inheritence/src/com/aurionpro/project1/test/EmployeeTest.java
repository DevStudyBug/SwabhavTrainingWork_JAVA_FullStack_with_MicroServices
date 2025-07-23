package com.aurionpro.project1.test;

import java.util.Scanner;

import com.aurionpro.project1.model.Employee;
import com.aurionpro.project1.model.JobRole;
import com.aurionpro.project1.model.Payroll;

public class EmployeeTest {
public static void main(String[] args) {
	 Payroll payroll = new Payroll();

     payroll.addEmployee(new Employee(101, "Alice", 90000, JobRole.MANAGER));
     payroll.addEmployee(new Employee(102, "Bob", 75000, JobRole.DEVELOPER));
     payroll.addEmployee(new Employee(103, "Charlie", 65000, JobRole.DESIGNER));
     payroll.addEmployee(new Employee(104, "Max", 50000, JobRole.TESTER));
     payroll.addEmployee(new Employee(105, "Ginny", 45000, JobRole.HR));
   payroll.addEmployee(new Employee(105, "Goergia", 45000, JobRole.HR));

     payroll.displayAllEmployees();
//
//     payroll.searchByRole(JobRole.DEVELOPER);
//     payroll.searchByRole(JobRole.HR);
//     payroll.searchByRole(JobRole.MANAGER);

     Scanner scanner = new Scanner(System.in);
     String choice;
     
     do {
    	    System.out.println("\nEnter the Role to Search (MANAGER, DEVELOPER, DESIGNER, TESTER, HR):");
    	    String roleInput = scanner.next().toUpperCase();

    	    switch (roleInput) {
    	        case "MANAGER":
    	            payroll.searchByRole(JobRole.MANAGER);
    	            break;

    	        case "DEVELOPER":
    	            payroll.searchByRole(JobRole.DEVELOPER);
    	            break;

    	        case "DESIGNER":
    	            payroll.searchByRole(JobRole.DESIGNER);
    	            break;

    	        case "TESTER":
    	            payroll.searchByRole(JobRole.TESTER);
    	            break;

    	        case "HR":
    	            payroll.searchByRole(JobRole.HR);
    	            break;

    	        default:
    	            System.out.println("Invalid Role Entered.");
    	    }

    	    System.out.println("\nWanna search more? (yes/no):");
    	    choice = scanner.next().toLowerCase();

    	} while (choice.equals("yes"));

     System.out.println("Exiting... Thank you!");
 } 
}