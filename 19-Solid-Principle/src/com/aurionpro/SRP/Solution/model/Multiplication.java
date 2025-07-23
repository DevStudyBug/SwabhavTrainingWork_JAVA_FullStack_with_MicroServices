package com.aurionpro.SRP.Solution.model;

public class Multiplication {
	public void multi(Calculator calculator) {
		double n1 = calculator.getNumber1();
		double n2 = calculator.getNumber2();
		System.out.println("Multiplication of "+n1+" and " + n2+ "are: "+ (n1*n2));
	}
}
