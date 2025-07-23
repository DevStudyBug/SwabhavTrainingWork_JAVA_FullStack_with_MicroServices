package assignment.week1;

import java.util.Scanner;

public class Q5_WordCount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the sentence: ");
		String sentence = scanner.nextLine();
		String regex = "[,\\.\\s]";
		String [] word = sentence.split(regex);
		int wordcount = word.length;
		System.out.println("The number of words are :"+wordcount);
		scanner.close();
		}
	}

