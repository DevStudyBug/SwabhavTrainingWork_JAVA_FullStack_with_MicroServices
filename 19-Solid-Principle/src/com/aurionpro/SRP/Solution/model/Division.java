package com.aurionpro.SRP.Solution.model;

public class Division {
	public void div(Calculator calculator) {
		double n1 = calculator.getNumber1();
		double n2 = calculator.getNumber2();
		System.out.println("Division of "+n1+" and " + n2+ "are: "+ (n1/n2));
	}
}
