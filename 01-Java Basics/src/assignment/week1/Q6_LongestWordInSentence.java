package assignment.week1;

import java.util.Scanner;

public class Q6_LongestWordInSentence {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the sentence: ");
	String sentence = scanner.nextLine();
	String regex = "[,\\.\\s]";
	
	String [] word = sentence.split(regex);
	String longestWords ="";
	int maxlength = 0;
	for (int i=0; i< word.length ;i++) {
		String currentWord = word[i];
		int length = currentWord.length();
		
		if(length > maxlength) {
			maxlength = length;
			longestWords = currentWord;
		}
	}
	System.out.println("Longest word is: " + longestWords);
	System.out.println("Length of longest word: " + maxlength);
	scanner.close();
	
}	
}

