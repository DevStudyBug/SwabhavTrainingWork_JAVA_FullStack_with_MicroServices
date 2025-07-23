package assignment.day4;

import java.util.Scanner;

public class evenOddRearrangement {
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the size of an array ");
			int size = scanner.nextInt();
			
			int left = 0;
			int right = size -1;
			int[] arr = new int[size];
			int[] result = new int[size];
			
			System.out.println("Enter the value of array");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			
			for (int i =0 ; i< size; i++) {
				if(arr[i]%2 == 0 ) {
					result[left]= arr[i];
					left++;
				}
				else {
					result[right] =arr[i];
					right--;
				}
			}
			System.out.println("Array after arranging even and odd number : ");
			for (int number : result)  //for each loop
			{   
				System.out.print(number + " ");
			}
			scanner.close();
	}
}

/*1. Problem:
Write a Java program that rearranges a 1-D array so that:
All even numbers appear first
All odd numbers appear after all even numbers
(Order inside even/odd groups does not matter)

Example Input: [1, 2, 3, 4, 5, 6]
Output: [2, 4, 6, 1, 3, 5] or any valid even-odd arrangement

Requirements:
Use a single array (not creating separate arrays for even and odd).
Use loops and if-else logic. 
*/
