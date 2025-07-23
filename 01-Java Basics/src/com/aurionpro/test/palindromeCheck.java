package com.aurionpro.test;

public class palindromeCheck {
	public static void main(String[] args) {
		int num = 3443 , reverse = 0;
		int originalnum = num;
		
		while (num != 0) {
			reverse = reverse * 10 + (num % 10);
			num = num / 10;
		}
		
		if (originalnum == reverse) {
			System.out.println("number is palindrome");
		} else {
			System.out.println("number is not palindrome");
		}
	}
}
