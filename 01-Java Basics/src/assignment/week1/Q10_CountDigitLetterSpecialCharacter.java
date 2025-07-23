package assignment.week1;
/*10. Count digits, letters, and special characters in a string
 Input: "Java123@#"
 Output: Letters: 4, Digits: 3, Special: 2
*/

import java.util.Scanner;

public class Q10_CountDigitLetterSpecialCharacter {
public static void main(String[] args) {
	int letter = 0, digit =0 , specialChar =0 ;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter a String: "); //java@132324
	String str = scanner.nextLine().trim().toLowerCase() ;
	
	for (int i=0 ; i < str.length(); i++) {
		char ch = str.charAt(i);
		if (Character.isLetter(ch)) {
			letter++;
		} 
		else if(Character.isDigit(ch)) {
			digit++;
		}
		else {
			specialChar++;
		}
		
	}System.out.println("Number of Letter : "+ letter + "\nNumber of digit: "+ digit + "\nNumber of special character : "+ specialChar);
	
	scanner.close();
	
}
}
