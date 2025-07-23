package com.aurionpro.model;
//3. Employee Bonus Validator:
//- Create an Employee class with private fields: name, salary, bonus.
//- Set bonus only if it is less than or equal to 20% of salary.
//- Write methods to display salary and final salary (salary + bonus).
//- Use setter to test validation.
public class BonusValidator {
	String name;
	double salary;
	double bonus;
	
	public String getname() {
		return name;
	}
	public double getsalary() {
		return salary;
	}
	public double getbonus() {
		return bonus;
	}
	public double getfinalsalary() {
		return salary + bonus;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setsalary(double salary) {
		this.salary = salary;
		
	}
	public void setbonus(double bonus) {
		if(bonus < 0.2 * salary) {
			this.bonus = bonus;
		}
		else {
			System.out.println("Bonus is not added !");
			this.bonus = 0;
		}
		
		
	}
	
	public String toString(){
		return " BonusValidator {  name= " + name + ", salary=" + salary + ", Final salary=" + getfinalsalary()  + "    }";
	}
	
}
