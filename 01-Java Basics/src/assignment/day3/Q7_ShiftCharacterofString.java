package assignment.day3;

import java.util.Scanner;

public class Q7_ShiftCharacterofString {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input string
	        System.out.print("Enter the string: ");
	        String str = scanner.nextLine();

	        // Input shift amount
	        System.out.print("Enter the number of positions to shift: ");
	        int shift = scanner.nextInt();

	        // Normalize shift
	        int len = str.length();
	        shift = shift % len;

	        // Input shift direction
	        System.out.print("Shift direction (left/right): ");
	        scanner.nextLine(); // consume newline
	        String direction = scanner.nextLine().toLowerCase();

	        String shiftedStr = "";

	        if (direction.equals("left")) {
	            shiftedStr = str.substring(shift) + str.substring(0, shift);
	        } else if (direction.equals("right")) {
	            shiftedStr = str.substring(len - shift) + str.substring(0, len - shift);
	        } else {
	            System.out.println("Invalid direction!");
	            return;
	        }

	        System.out.println("Shifted string: " + shiftedStr);
	        scanner.close();
	    }
	
}
