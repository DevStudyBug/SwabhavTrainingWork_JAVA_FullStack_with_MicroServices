package com.aurionpro.test;

import java.util.Scanner;

public class methodWithoutParameter {
	
	public static void greet(String name) {
		System.out.println("Good morning " +name  );
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String name = scanner.nextLine();
		
		greet(name);
	
	}
}
