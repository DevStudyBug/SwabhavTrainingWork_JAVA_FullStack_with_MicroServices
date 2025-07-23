package assignment.day3;

import java.util.Scanner;

public class Q8_SubstringInString {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input the main string
	        System.out.print("Enter the main string: ");
	        String mainString = scanner.nextLine();

	        // Input the substring
	        System.out.print("Enter the substring to search: ");
	        String subString = scanner.nextLine();

	        // Check if substring exists
	        if (mainString.contains(subString)) {
	            int index = mainString.indexOf(subString);
	            System.out.println("Substring found at index: " + index);
	        } else {
	            System.out.println("Substring not found.");
	        }

	        scanner.close();  
	}

}
