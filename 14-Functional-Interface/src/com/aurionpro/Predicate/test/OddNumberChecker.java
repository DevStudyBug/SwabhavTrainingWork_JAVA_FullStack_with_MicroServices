package com.aurionpro.Predicate.test;

import java.util.function.Predicate;

public class OddNumberChecker {
	public static void main(String[] args) {
		Predicate<Integer> isOdd = num-> num%2!=0;
		System.out.println("Odd number from 1 to 10");
		for(int i = 0;i<=10;i++) {
			if(isOdd.test(i)) {
				System.out.println(i);
			}
		}
	}
}
