package com.aurionpro.test;

import com.aurionpro.model.Add;
import com.aurionpro.model.Istudent;

public class Student {
	public static void main(String[] args) {
		
// Using Lmabda Expression
//		Istudent student = msg-> msg;
//		System.out.println(student.greet("Mssg is hello"));
		// addition
//		Istudent student = (a,b)-> a+b;
//		System.out.println(student.add(2,3));

		
// Using Anonymous class
//		Istudent student = new Istudent() {
//			@Override
//			public int add(int a, int b) {		
//				return a+b;
//			}	
//		};
//		System.out.println("addition is " + student.add(2, 2));

		
// using Class Implement Interface
//		Istudent student = new Add();
//		System.out.println(student.add(2, 3));
	}
}
