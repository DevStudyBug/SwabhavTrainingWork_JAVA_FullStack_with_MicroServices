package assignment.day3;

import java.util.Scanner;

public class Q1_readAndDisplayArrayElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = scanner.nextInt();
		
		String[] arr = new String[size];
		scanner.nextLine();
		
		// read element 
		for (int i =0; i < arr.length; i++) {
			System.out.println("Enter element at index " + i + ": ");
			arr[i] = scanner.nextLine();
		}
		
		//display element
		System.out.println("You enter element : ");
		for(String display: arr) {
			System.out.println("You enter the element : "+ display);
		}
		scanner.close();
	}
}
