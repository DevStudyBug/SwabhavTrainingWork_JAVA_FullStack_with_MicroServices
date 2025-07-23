package com.aurionpor.model;

public class throwsDemo {
	public static void ageCheker(int age) {	
	if (age < 18) {
        throw new ArithmeticException("Not allowed to vote.");
        //throw new NullPointerException("Null pointer Exception");
    }
    System.out.println("Eligible to vote");
}

public static void main(String[] args) {
    ageCheker(15);
}
}
