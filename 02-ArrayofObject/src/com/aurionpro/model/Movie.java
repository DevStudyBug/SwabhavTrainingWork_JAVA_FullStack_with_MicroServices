package com.aurionpro.model;

public class Movie {
String movieName ;
String genre;
public Movie(String movieName , String genre) {
	this.movieName = movieName;
	this.genre = genre;
}
public void display() {
	System.out.println(" ");
	System.out.println("Movie name is "+ movieName +" "+ "of genre action is "+ genre);
	System.out.println("------------------------------------------------------------------");
}
}
