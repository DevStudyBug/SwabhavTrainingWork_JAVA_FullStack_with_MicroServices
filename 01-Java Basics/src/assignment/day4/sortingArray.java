package assignment.day4;

import java.util.Scanner;

//2. Sorting an Array (without using in-built functions)
public class sortingArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int size = scanner.nextInt();
		
		int[] arr = new int[size];
	
		System.out.println("Enter the value of array (before sort) : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		
		int temp = 0 ;
		for (int i = 0; i<size; i++) {
			for(int j = i+1 ;j< size;j++) {
				if(arr[i]>arr[j]) {
					temp =arr[i];
					arr[i]=arr[j];
					arr[j]= temp;	
				}	
			}	
		}
		System.out.print("element of array after sort : ");
		for (int result : arr)
			System.out.print( result + " ");
		scanner.close();
	}
	
	
}
