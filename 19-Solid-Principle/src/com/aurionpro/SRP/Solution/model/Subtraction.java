package com.aurionpro.SRP.Solution.model;

public class Subtraction {
	public void sub(Calculator calculator) {
		double n1 = calculator.getNumber1();
		double n2 = calculator.getNumber2();
		System.out.println("Subtraction of "+n1+" and " + n2+ "are: "+ (n1-n2));
	}
}
