package com.aurionpro.model;
/*5. Library Book Tracker:
- Create a Book class with private fields: title, author, issued.
- Use:
 > Getter for title and author
 > Setter for issued (true or false)
- Write a method getStatus() that returns "Available" or "Issued".
- Create 2 book objects and simulate issuing and returning books*/

public class Library {
	private String title;
	private String author;
	private boolean issued ;
	public String gettitle() {
		return title;
	}
	public String getauthor() {
		return author;
	}
	public void setissued(boolean issued) {
		this.issued = issued;
		
	}
	public void settitle(String title) {
		this.title = title;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getStatus() {
		if(issued == true) {
			return "The book is issued or Not available!";
		}
		else {
			return "Book is available! ";
		}
	}
	public void display() {
		System.out.println("Book Title: "+ title);
		System.out.println("Author name: "+ author);
		System.out.println("Issued:" + getStatus());
	}
}
