package assignment.day3;

import java.util.Scanner;

public class Q4_SecondMaxOfArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array ");
		int size = scanner.nextInt();

		if (size < 2) {
			System.out.println("You need at least 2 elements to find the second max.");
			return;
		}
		// read element
		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter element of index " + i);
			arr[i] = scanner.nextInt();
		}

		int max, secondMax; // initialize
		// compare first two elements , example {50, 20, 50, 10}
		if (arr[0] > arr[1]) {
			max = arr[0]; // 50
			secondMax = arr[1]; // 20
		} else {
			max = arr[1];
			secondMax = arr[0];
		}
		// check rest of element
		for (int i = 2; i < size; i++) {
			if (arr[i] > max) { // arr[2] = 50 > max =50 ❌ , arr[3] =10 >50 ❌
				secondMax = max;
				max = arr[i];
			}
			// prevent duplicate
			else if (arr[i] > secondMax && arr[i] != max) // 50>20 and 50 != 50 , 10 > 20 && 10 != 50
			{
				secondMax = arr[i];

			}
			
		}
		
		// Final check if secondMax was actually found
        if (max == secondMax) {
            System.out.println("⚠️ No second maximum found (all elements may be same).");
        } else {
            System.out.println("✅ Maximum value: " + max);
            System.out.println("✅ Second maximum value: " + secondMax);
        }

		scanner.close();
	}
}
