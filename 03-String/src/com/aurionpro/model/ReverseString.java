package com.aurionpro.model;

import java.util.Scanner;

//4. reverse a string
public class ReverseString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = scanner.nextLine();

		String reverseStr = "";
		char ch;
		
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			reverseStr = ch + reverseStr; // a + "" , b + a , c + ba
		}
		
//      Reverse using StringBuilder
//		StringBuilder sb = new StringBuilder(str);  
//		String reverseStr = sb.reverse().toString();
		
		System.out.println("Enter string is: " + str);
		System.out.println("Reversed string is: " + reverseStr);
	}
}
