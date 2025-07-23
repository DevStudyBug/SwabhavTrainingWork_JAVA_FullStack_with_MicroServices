package assignment.day3;

import java.util.Scanner;

public class Q3_SumOfArray {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the size of an array ");
	int size = scanner.nextInt();
	int[] arr = new int[size];
	int sum = 0;

	for (int i = 0; i < arr.length; i++) {
		System.out.println("Enter element of index " + i);
		arr[i] = scanner.nextInt();
		sum += arr[i];
	}
	System.out.println("Sum of element of array is : "+ sum);
}
}
