package com.aurionpro.SRP.Solution.test;

import java.util.Scanner;

import com.aurionpro.SRP.Solution.model.Addition;
import com.aurionpro.SRP.Solution.model.Calculator;

public class CalculatorTest {
public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter First number: ");
	double n1 = scanner.nextDouble();
//	calculator.getNumber1();
	System.out.println("Enter second number: ");
	double n2 = scanner.nextDouble();
//	calculator.getNumber2();
	Calculator calculator = new Calculator(n1, n2);
	
	System.out.println("Addition: ");
	Addition add = new Addition();
	add.add(calculator);
}
}
