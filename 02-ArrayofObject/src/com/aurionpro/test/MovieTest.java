package com.aurionpro.test;
import com.aurionpro.model.Movie;
import java.util.Scanner;

	public class MovieTest {
		public static void main(String[] arg ) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of movies ");
		int numberofMovies = scanner.nextInt();
		scanner.nextLine();
		 
		Movie[] movies = new Movie[numberofMovies];
		System.out.println("Enter the name and genre of Action Movies: ");
		
		for (int i =0 ; i <numberofMovies; i++) {
			System.out.println("Enter the movie name: ");
			String movieName = scanner.nextLine();
			
			System.out.println("Enter the genre: ");
			String genre = scanner.nextLine();
					
			movies[i]  = new Movie(movieName , genre);
			
		}
		for (Movie details : movies ) {
			details.display();
		}
}


}
