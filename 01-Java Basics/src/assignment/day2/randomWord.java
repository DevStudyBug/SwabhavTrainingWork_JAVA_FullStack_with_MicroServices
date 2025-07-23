package assignment.day2;

import java.util.Random;
import java.util.Scanner;

public class randomWord {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of word : "); //6
		int length = scanner.nextInt();
		
		String letters ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		StringBuilder randomWord = new StringBuilder(); // StringBuilder is mutable instead of string concatenation +
				 
		Random random = new Random();
		
		for (int i =0; i<length; i++) { 
			int index = random.nextInt(letters.length());
			randomWord.append(letters.charAt(index));
		} 
		
		System.out.println("Random Word "+ "of length " +length+ " is : "+ randomWord.toString());

        scanner.close();
	}
}
