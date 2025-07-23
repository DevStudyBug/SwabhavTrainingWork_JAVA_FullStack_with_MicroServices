package com.aurionpro.test;
import com.aurionpro.model.Book;
import java.util.Scanner;
 
public class BookTest {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the number of books: ");
	int numberofbooks = scanner.nextInt();
	
	Book[] books = new Book[numberofbooks];
	
	System.out.println("Enter the details of Book ");
	for(int i = 0; i< numberofbooks ; i++) {
		System.out.print("Enter Book ID ");
		
	    int bookId = scanner.nextInt();

	    scanner.nextLine();
	    System.out.print("Enter Book Title ");
	    String titleName = scanner.nextLine();
	    
	    books[i] = new Book(bookId , titleName);
	    
	}
	
	for(Book details : books) {
		details.display();
	}
	
	
}
}


//doubt  use while loop or getter and setter
//check if Book id is same or not
//int duplicateCount = 0;
//for (int i = 0; i < numberofbooks; i++) {
//    for (int j = i + 1; j < numberofbooks; j++) {
//        if (books[i] == [j]) {
//            duplicateCount++;
//            break;
//        }
//    }
//if(duplicateCount != 0) {
//	System.out.println("Book id must be unique");
//}
