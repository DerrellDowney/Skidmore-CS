package edu.skidmore.cs226.lab09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Redbox{

	/**
	 * array of movies
	 */
	static Movie[] movies = new Movie[2];
	
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(Redbox.class);
	}
	
	/**
	 * populating the movie array with movies
	 * @param arr represents array of movies
	 */
	public void populateArray(Movie[] arr) {
		LOG.info("populating movies with user inputs");
		Scanner keyboard = new Scanner(System.in);
		String title = "";
		String director = "";
		String runTime = "";
		String release = "";
		for (int i = 0; i < movies.length; i++) {
			arr[i] = new Movie();
			System.out.println("Enter data for movie: " + i);
			System.out.print("Title: ");
			title = title + keyboard.nextLine();
			arr[i].setTitle(title);
			System.out.print("Director: ");
			director = director + keyboard.nextLine();
			arr[i].setDirector(director);
			System.out.print("Running time (minutes): ");
			runTime = runTime + keyboard.nextLine();
			arr[i].setRunTime(runTime);
			System.out.print("Year released: ");
			release = release + keyboard.nextLine();
			arr[i].setRelease(release);
			title = "";
			director = "";
			runTime = "";
			release = "";
		}
		
	}
	
	/**
	 * getting the menu choice of the user
	 * @return the movie choice
	 */
	public int menuChoice() {
		LOG.info("getting user menu choice");
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Choice? ");
		int choice = Integer.parseInt(keyboard.nextLine());
		return choice;
		
	}
	
	/**
	 * listing the movies
	 * @param arr array of movies
	 */
	public void listMovies(Movie[] arr) {
		String word = "";
		for (int i = 0; i < movies.length; i++) {
			LOG.info("returning movie " + arr[i].toString());
			word = arr[i].toString();
			System.out.println(word);
		}
	}
	
	/**
	 * showing the menu of options
	 */
	public void showMenu() {
		LOG.info("Showing list of options");
		System.out.println("Welcome to redbox. Please choose an option.");
		System.out.println("1: List the movies known to redbox (whether borrowed or not)");
		System.out.println("2: Borrow a movie");
		System.out.println("3: Return a movie");
		System.out.println("4: List the movies currently borrowed");
		System.out.println("5: List the movies in the kiosk (available to borrow)");
		System.out.println("6: Quit");

	}
	
	/**
	 * Method to borrow a movie by title
	 * @param arr array of movies
	 */
	public void borrowMovie(Movie[] arr) {
		Scanner keyboard = new Scanner(System.in);
		LOG.info("getting the movie");
		System.out.print("What movie(enter title)?: ");
		String title = keyboard.nextLine();
		LOG.info("setting the due date");
		System.out.print("When do you want it due?: ");
		String due = keyboard.nextLine();
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(count == (arr.length)){
				LOG.info("No available movie");
				System.out.println("There is no such movie to borrow");
			}
			if(arr[i].getTitle().equals(title)) {
				LOG.info("changing the movies due date");
				arr[i].setDueDate(due);
				System.out.println("Setting " + title+ "'s due date to "+due);
				
				break;
			}
			
			count++;
		}
		
		
		
	}
	
	/**
	 * returning the list of borrowed movies
	 * @param arr array of movies
	 */
	//cannot get these two methods to work
	public void listBorrowed(Movie[] arr) {
		String word = "";
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getDueDate() != null) {
				word = arr[i].toString();
				System.out.println(word);
			}
			
		}
	}
	
	/**
	 * Returning the remaining movies
	 * @param arr array of movies
	 */
	public void listRemaining(Movie[] arr) {
		String word = "";
		for(int i = 0; i < arr.length; i++) {
			LOG.info("returning movie " + arr[i] );
			if(arr[i].getDueDate() ==null) {
				LOG.info("returning movie " + arr[i] );
				word = arr[i].toString();
				System.out.println(word);
			}
		}
	}
	
	/**
	 * Returning the selected movie
	 * @param arr array of movies
	 */
	public void returnMovie(Movie[] arr) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What movie(enter title)?: ");
		String title = keyboard.nextLine();
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(count == (arr.length)){
				LOG.info("There is no movie to borrow");
				System.out.println("There is no such movie to borrow");
			}
			if(arr[i].getTitle().equals(title)) {
				LOG.info("setting the movies due date to null");
				arr[i].setDueDate(null);
				System.out.println("Setting " + title+ "'s due date to "+null);
				break;
			}
			
			count++;
		}
	}
	
	
	public static void main(String[] args) {
		Redbox box = new Redbox();
		
		
		int value = 0;
		box.populateArray(movies);
		
		while (value != 6) {
			box.showMenu();
			value = box.menuChoice();
			if(value == 1 ) {
				LOG.info("Showing list of movies");
				box.listMovies(movies);
			}
			if(value == 2 ) {
				LOG.info("borrowing a movie");
				box.borrowMovie(movies);
			}
			if(value == 3 ) {
				LOG.info("returning a movie");
				box.returnMovie(movies);
			}
			if(value == 4 ) {
				LOG.info("listing borrowed movies");
				box.listBorrowed(movies);
			}
			if(value == 5 ) {
				LOG.info("listing remainging movies");
				box.listRemaining(movies);
			}
			
		}
		LOG.info("Exiting program");
		System.out.println("Goodbye!");
	}
}
