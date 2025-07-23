package assignment.week1;
//4. Find the frequency of a character in a string (without stringbuilder)

import java.util.Scanner;

public class Q4_Frequency {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scanner.nextLine();
		
		int count=0;
		System.out.println("Enter the character to it's check frequency: ");
		char ch = scanner.next().charAt(0);
		
		for (int i =0; i<str.length(); i++) {
			if(str.charAt(i)==ch) {
				count++;
			}	
		}	
		System.out.println("Frequency of "+ ch + " in string "+ str +" is "+ count);
		scanner.close();
	}
}
