package assignment.week1;
//9. Remove all duplicate characters from a string
// Input: "programming"
// Output: "progamin"

import java.util.Scanner;
public class Q9_RemoveDuplicateCh {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = scanner.nextLine();
	
	StringBuilder result = new StringBuilder(); // programming
	
	for (int i=0 ;i< str.length() ; i++) {
		char ch = str.charAt(i);
		
		// Check if this character is already in result
        if (result.indexOf(String.valueOf(ch)) == -1) {
            result.append(ch); // If not, add it
        }
    }

    System.out.println("String without duplicates: " + result);
    scanner.close();
	}
	
 
}

