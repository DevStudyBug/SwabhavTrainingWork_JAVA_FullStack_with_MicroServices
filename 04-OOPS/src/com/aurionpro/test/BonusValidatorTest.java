package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.BonusValidator;

//3. Employee Bonus Validator:
//- Create an Employee class with private fields: name, salary, bonus.
//- Set bonus only if it is less than or equal to 20% of salary.
//- Write methods to display salary and final salary (salary + bonus).
//- Use setter to test validation.
public class BonusValidatorTest {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter Employee name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter Employee salary: ");
		double salary = scanner.nextDouble();
		
		System.out.println("Enter Employee bonus: ");
		double bonus = scanner.nextDouble();
		
		BonusValidator bonusValidator = new BonusValidator();
		bonusValidator.setname(name);
		bonusValidator.setsalary(salary);
		bonusValidator.setbonus(bonus);
		
		System.out.println(bonusValidator.toString());
	}
}
