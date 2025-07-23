package com.aurionpro.test;
import java.util.Scanner;
public class SwitchCase {
public static void main(String [] args ) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a month number between (1 - 12) of year 2025 : ");
		int month = scanner.nextInt();
		
		switch (month) {
		case 1: System.out.println("Number of days in january is 30");
		break;
		
		case 2: System.out.println("Number of days in fabruary is 28");
		break;
		
		case 3: System.out.println("Number of days in march is 31");
		break;
		
		case 4: System.out.println("Number of days in april is 30");
		break;
		
		case 5: System.out.println("Number of days in may is 31");
		break;
		
		case 6: System.out.println("Number of days in june is 30");
		break;
		
		case 7: System.out.println("Number of days in july is 31");
		break;
		
		case 8: System.out.println("Number of days in august is 31");
		break;
		
		case 9: System.out.println("Number of days in september is 30");
		break;
		
		case 10: System.out.println("Number of days in october is 31");
		break;
		
		case 11: System.out.println("Number of days in november is 30");
		break;
		
		case 12: System.out.println("Number of days in december is 31");
		break;
		
		default : System.out.println("Please choose number between 1-12 ");
		
		}
		
	}
}
