package com.aurionpro.test;

/*5. Library Book Tracker:
- Create a Book class with private fields: title, author, issued.
- Use:
 > Getter for title and author
 > Setter for issued (true or false)
- Write a method getStatus() that returns "Available" or "Issued".
- Create 2 book objects and simulate issuing and returning books*/
import java.util.Scanner;

import com.aurionpro.model.Library;

public class LibraryTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Library Book Tracker ");
		System.out.println("Enter number Book");
		int num = scanner.nextInt();
		scanner.nextLine();
		Library[] library = new Library[num];

		for (int i = 0; i < num; i++) {
			library[i] = new Library();
			System.out.println("Enter Book Title : ");
			String title = scanner.nextLine();
			library[i].settitle(title);

			System.out.println("Enter Book Author name : ");
			String author = scanner.nextLine();
			library[i].setauthor(author);

			System.out.println("Enter Book issued (yes / no): ");
			String issued = scanner.nextLine();

			boolean isIssued = issued.equalsIgnoreCase("yes"); // Returns true if input is "yes" (case-insensitive)

			library[i].setissued(isIssued); 

			
		}
		
		for(Library l: library) {
		System.out.println("----Book Status-----" );
		l.display();
//		library.display();

	}
}
}
