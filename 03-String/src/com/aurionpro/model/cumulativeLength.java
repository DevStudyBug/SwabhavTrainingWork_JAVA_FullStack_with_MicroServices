package com.aurionpro.model;

import java.util.Scanner;

public class cumulativeLength {
	//1. Take an array of Strings input from the user & find the cumulative (combined) length of all those strings.

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Size of array :");
		int size = scanner.nextInt();
		scanner.nextLine();
		String []arr = new String[size];
		
		for(int i =0;i<size;i++) {
			System.out.println("Enter the "+(i+1)+" string: ");
			arr[i]= scanner.nextLine();
		}
		System.out.println("You entered : ");
		
		for(int i =0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		
		int sum = 0;
		for(String result: arr) {
			sum += result.length();		
			} 
		System.out.println("");
		System.out.println("Cumulative (combined) length of all those strings: "+sum);
		scanner.close();
	}	

	}
