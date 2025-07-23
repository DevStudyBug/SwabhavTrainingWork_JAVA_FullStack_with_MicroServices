package assignment.day2;

import java.util.Random;
import java.util.Scanner;

public class RandomWordGuesserApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter length of word");
		int length = scanner.nextInt();
		scanner.nextLine();
		
		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		StringBuilder randomWord = new StringBuilder(); //mutable
		Random random = new Random();
		
		for (int i=0 ; i<length;i++) {
			int index = random.nextInt(letters.length());
			randomWord.append(letters.charAt(index));
		}
		
		String word = randomWord.toString(); //convert it to a String
		int lives = length ;
		
		char[] display = new char[length];
		for (int i = 0; i < length; i++) {
		    display[i] = '_';  //blank spaces
		}
		 System.out.println("You have " + lives + " lives to guess a " + length + "-letter word.");

		 //start 
		 while (lives > 0 && !String.valueOf(display).equalsIgnoreCase(word)) {
	            System.out.println("Word : " + String.valueOf(display));
	            System.out.println("Lives left : " + lives);
	            System.out.print("Guess a letter : ");
	            String input = scanner.nextLine();
	        
	         // Validate input
	            if (input.isEmpty()) {
	                System.out.println("Please enter a letter.");
	                continue;
	            }

	            char guess = input.charAt(0); // Take only the first character
	            boolean correct = false;

	            // Check if the guessed letter is in the word
	            for (int i = 0; i < length; i++) {
	                if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(guess) && display[i] == '_') {
	                    display[i] = word.charAt(i);  // Reveal the letter
	                    correct = true;
	                }
	            }

	            // Print result of the guess
	            if (correct) {
	                System.out.println("Correct guess!");
	            } else {
	                lives--;
	                System.out.println("Wrong guess.");
	            }
	        }

	        // Step 5: Game over message
	        if (String.valueOf(display).equalsIgnoreCase(word)) {
	            System.out.println("\n Congratulations! You guessed the word: " + word);
	        } else {
	            System.out.println("\n Game Over! The correct word was: " + word);
	        }

	        scanner.close();
	    }
	}
	