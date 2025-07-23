package com.project1.test;

import com.project1.model.Developer;
import com.project1.model.Employee;
import com.project1.model.Intern;

public class EmployeeTest {
public static void main(String[] args) {
	Employee[] employee = new Employee[4];
	employee[0] = new Developer("Anshika",101, 3300.0 , 1000);
	employee[1] = new Developer("Alok",102, 3300 , 500);
	employee [2]= new Intern("sheetal" , 103, 15000);
	employee [3]= new Intern("bhaps" , 104, 1000);
	
	System.out.println("------Employee Details --------\n");

	for  (Employee emp : employee) {
			emp.calculateSalary();
	}
}
}
	

/*
 * In the main() method:  Create an array of 2 Developer and 2 Intern objects.
 *  Loop through the array and print names with their salaries.
 */