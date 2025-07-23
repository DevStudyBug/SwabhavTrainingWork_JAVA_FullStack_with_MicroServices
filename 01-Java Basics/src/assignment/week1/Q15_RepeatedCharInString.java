package assignment.week1;
//15. Find Repeated Characters in a String
//Input a string and print all duplicate characters (e.g. "programming" → r, g, m)
import java.util.Scanner;

public class Q15_RepeatedCharInString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String str = scanner.nextLine();
		
		StringBuilder result = new StringBuilder(); // programming
		
		for (int i=0 ;i< str.length() ; i++) {
			char ch = str.charAt(i);
			
			// Check if this character is not already in result
			 if (str.indexOf(ch) != str.lastIndexOf(ch) && result.indexOf(String.valueOf(ch)) == -1) {
	            result.append(ch); // If not, add it
	        }
	    }

	    System.out.println("Duplicate characters : " + result.toString());
	    scanner.close();
		}
}
