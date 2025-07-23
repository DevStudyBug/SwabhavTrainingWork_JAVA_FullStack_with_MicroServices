
package assignment.day2;
import java.util.Scanner;
import java.util.Random;

public class Q3_randomWordGuesserApp {
    public static void main(String[] args) {
        // Word list 
        String[] words = {"rose", "lily", "tulip", "daffodil", "jasmine","apple", "banana", "cherry", "orange", "grapes"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Random word from above list
        String word = words[random.nextInt(words.length)];
        char[] guessedWord = new char[word.length()];
        int lives = 6;

        // Initialize blanks
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        // Game loop 
        while (lives > 0) {
            // Show current state
            System.out.print("Word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println("\nLives left: " + lives);

            // Ask user to guess
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean correctGuess = false;

            // Check and replace
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && guessedWord[i] == '_') {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                lives--; // Lose a life
            }

            // Check if word is fully guessed
            boolean allGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    allGuessed = false;
                    break;
                }
            }

            if (allGuessed) {
                System.out.print("Word: ");
                for (char c : guessedWord) {
                    System.out.print(c + " ");
                }
                System.out.println("\n You guessed the word! You win!");
                break;
            }
        }

        if (lives == 0) {
            System.out.println("Game Over! The word was: " + word);
        }

        scanner.close();
    }
}