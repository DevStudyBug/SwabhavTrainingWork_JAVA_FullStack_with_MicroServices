package com.aurionpor.model;

import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter age: ");
			int age = scanner.nextInt();
			System.out.println("age is " + age);
		}

		catch (NullPointerException e) {
//			e.printStackTrace();
			System.out.println(e);
			
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
			System.exit(0);
		}
		 finally {
			System.out.println("Finally executed");
		}

	}
}

