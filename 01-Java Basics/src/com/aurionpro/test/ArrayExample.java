package com.aurionpro.test;

import java.util.Scanner;

public class ArrayExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array ");
		int size = scanner.nextInt();
		int[] marks = new int[size];
		for (int i = 0; i < marks.length; i++) {
			System.out.println("Enter the value for " + i + " index");
			marks[i] = scanner.nextInt();
		}
		System.out.println("you entered : ");
		for (int result : marks)  //for each loop
		{   
			System.out.println(result);
		}
		scanner.close();
	}
}
