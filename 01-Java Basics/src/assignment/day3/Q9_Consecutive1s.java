package assignment.day3;

import java.util.Scanner;

public class Q9_Consecutive1s {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter size of array:");
	        int size = scanner.nextInt();

	        int[] arr = new int[size];
	        System.out.println("Enter elements (only 0s and 1s):");
	        for (int i = 0; i < size; i++) {
	            arr[i] = scanner.nextInt();
	        }
	        int maxCount = 0;
	        int currentCount = 0;

	        for (int i = 0; i < size; i++) {
	            if (arr[i] == 1) {
	                currentCount++; // increase current streak
	                if (currentCount > maxCount) {
	                    maxCount = currentCount; // update max
	                }
	            } else {
	                currentCount = 0; // reset count on 0
	            }
	        }
	        System.out.println("Maximum number of consecutive 1s: " + maxCount);

	        scanner.close();
	    }
	}
