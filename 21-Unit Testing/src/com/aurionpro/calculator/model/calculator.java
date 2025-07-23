package com.aurionpro.calculator.model;

public class calculator {
	public int additon(int num1, int num2) {
		return num1 + num2;
	}
	public int subtraction(int num1, int num2) {
		return num1 - num2;
	}
	 public int division(int num1 , int num2)
	    {
	        if(num2 == 0) throw new ArithmeticException("Cannot divide by zero");
	        return num1 / num2;
	    }
	 public int multiplication(int n1,int n2) {
		 return n1*n2;
	 }
	 
}
