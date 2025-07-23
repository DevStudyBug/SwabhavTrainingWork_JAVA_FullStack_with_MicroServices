package assignment.day4;

import java.util.Scanner;

public class ArrayIspalindrome {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");

        // Input array elements
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create and fill reversed array
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = arr[size - 1 - i];
        }
        
        boolean isPalindrome = true;
        for (int i = 0; i < size; i++) {
            if (arr[i] != reversed[i]) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("Array is palindrome");
        } else {
            System.out.println("Array is not palindrome");
        }

        scanner.close();
    }
}