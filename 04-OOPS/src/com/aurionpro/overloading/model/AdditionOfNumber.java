package com.aurionpro.overloading.model;

/*🔹 4. Addition of Numbers
Create a class Adder with:
 add(int, int)
 add(double, double)
 add(int, int, int)
Call them from main and show results.*/
public class AdditionOfNumber {
	int num1;
	double num2;
	int num3;
	public int add(int num1,int num2) {
		return num1+num2;
	}
	public double add(double n1,double n2) {
		return num1+num2;
	}
	public int add(int num1,int num2 , int num3) {
		return num1+num2+num3;
	}
}
