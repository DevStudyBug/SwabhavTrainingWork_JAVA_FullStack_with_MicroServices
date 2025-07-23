package com.aurionpro.model;
/*5. Input an email from the user. You have to create a username from the email by deleting the part that comes after ‘@’. Display that username to the user.
Example :
email = “amit@gmail.com” ; username = “amit” */

import java.util.Scanner;

public class EmailUsernameExtractor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email id: ");
		String emailId = scanner.nextLine();
		
		int atIndex = emailId.indexOf('@');
		
		if(atIndex != -1) {  
			String username = emailId.substring(0, atIndex);
			System.out.println("Username: " + username);
			
		}
		else {
			System.out.println("Invalid Email Id @ not found! ");
		}
		
	}
}
