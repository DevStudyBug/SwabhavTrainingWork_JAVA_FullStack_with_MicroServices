package assignment.week1;

import java.util.Scanner;
//7. Replace all spaces with - without using replace()

public class Q7_ReplaceSpaceWithMinus {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
			System.out.println("Enter the sntence: ");
			String sentence = scanner.nextLine();
			StringBuilder result = new StringBuilder();
			
			for (int i = 0; i < sentence.length(); i++) {
	            char ch = sentence.charAt(i);
	            if (ch == ' ') {
	                result.append('-');
	            } else {
	                result.append(ch);
	            }
	           
			
		} System.out.println("Original Sentence: "+ sentence);
        System.out.println("Modified: " + result.toString());
    }
	
}
