package com.aurionpro.overloading.test;

import com.aurionpro.overloading.model.AdditionOfNumber;

public class AdditionOfNumberTest {
	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 3;
		int num3 = 1;
		AdditionOfNumber addition = new AdditionOfNumber();
		System.out.println(addition.add(num1,num2));
		System.out.println(addition.add(num1 ,num2));
		System.out.println(addition.add(num1,num2,num3));

	}

}
