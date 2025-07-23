package com.aurionpro.model;

public class Book {
	int bookId;
	String title;
public Book(int bookId , String title) {
		this.bookId = bookId;
		this.title = title ;
	}
	public void display() {
		System.out.println(" ");
		System.out.println("Book Id: "+ bookId +" Title : "+ title);
		System.out.println("-------------------------------------------");
	}
}
