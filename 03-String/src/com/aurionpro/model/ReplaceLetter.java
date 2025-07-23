package com.aurionpro.model;
/*2. Input a string from the user. Create a new string called ‘result’ in which you will replace the letter ‘e’ in the original string with letter ‘i’.
Example :
original = “eabcdef’ ; result = “iabcdif”
Original = “xyz” ; result = “xyz” 
*/

import java.util.Scanner;

	public class ReplaceLetter {
		public static void main(String[] args) {
			Scanner scanner = new Scanner (System.in);
			System.out.println("Enter the String: ");
			String originalString =scanner.nextLine();
			
			String result = originalString.replace('e','i');
			System.out.println("Original String: "+ originalString);
			System.out.println("Modified String: "+ result);
			scanner.close();
		}
		
		
}
