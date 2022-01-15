package edu.skidmore.cs226.lab11indiv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.log4j.Logger;
/**
 * Redbox class storing the movies and allowing user to borrow and return them
 * @author ddowney
 *
 */
public class Redbox{

	/**
	 * Log attribute
	 */
	private static final Logger LOG;
	
	/**
	 * Setting up the logger
	 */
	static {
		LOG = Logger.getLogger(Redbox.class);
	}
	
	/**
	 * array of movies
	 */
	static Movie[] movies;
	
	/**
	 * file the movie is stored in
	 */
	private final static String FILE_NAME = "movies.txt";
	
	
	
	/**
	 * populating the movie array with movies
	 * 
	 */
	public void setUpMovies() {
		LOG.info("Counting the number of lines");
		int numMovies = lineCount();
		LOG.info("Subtracting one to get number of movies");
		numMovies--;
		LOG.info("creating movies array");
		movies = new Movie[numMovies];
		loadAllMoviesFromFile();
	}
	/**
	 * This method will find and return the line count of the file given in 
	 * the attribute FILE_NAME
	 * @return the line count of the file
	 */
	private int lineCount() {
		LineNumberReader reader = null;
		int lineCount = 0;
		try {
			reader = new LineNumberReader(new FileReader(FILE_NAME));
			while (reader.readLine() != null) {
				;
			}
			lineCount = reader.getLineNumber();}
		catch (Throwable throwable) {
			LOG.error(throwable);
		}
	
		finally {
			if (reader != null) {
				try {
					LOG.info("trying to close the reader");
					reader.close();
					}
				catch (Throwable throwable) {
					LOG.error(throwable);
					}
				}
			}
		LOG.info(FILE_NAME + " has "+ lineCount + " lines");
		return lineCount;
		}
	
	/**
	 * This method will load the movies into the array 
	 * and separated values based on a tab
	 */
	private void loadAllMoviesFromFile() {
		LineNumberReader reader = null;
		String oneRecord;
		String[] parsedRecord;
		int recordNumber = 0;
		try {
			LOG.info("creating the line number reader");
			reader = new LineNumberReader(new FileReader(FILE_NAME));
			LOG.info("Reading the line numbers");
			reader.readLine();
			
			while((oneRecord = reader.readLine()) != null) {
				parsedRecord = oneRecord.split(";");
				LOG.info("adding a movie");
				Movie movie = new Movie();
				LOG.info("Adding title to movie");
				movie.setTitle(parsedRecord[0]);
				LOG.info("Adding director to movie");
				movie.setDirector(parsedRecord[1]);
				LOG.info("Adding runtime to movie");
				movie.setRunTime(parsedRecord[2]);
				LOG.info("Adding release to movie");
				movie.setRelease(parsedRecord[3]);
				LOG.info("Adding due date to movie");
				movie.setDueDate(parsedRecord[4]);
				LOG.info("Adding movie to the array");
				movies[recordNumber] = movie;
				++recordNumber;
			}
		}
		catch(Throwable throwable) {
			LOG.error(throwable);
		}
		finally {
			if (reader != null) {
				try {
					LOG.info("trying to close the reader");
					reader.close();
				}
				catch (Throwable throwable) {
					LOG.error(throwable);
				}
			}
		}
	}
	
	/**
	 * Writing the data of the movies to the file
	 */
	private void writeDataToFile() {
		PrintWriter write = null;
		try {
			write = new PrintWriter(new FileWriter(FILE_NAME));
			write.println("TITLE; DIRECTOR; RUNTIME; RELEASE; DUE");
			for(Movie movie: movies) {
				LOG.info("Adding movie title to the file");
				write.print(movie.getTitle() + "; ");
				LOG.info("Adding movie director to the file");
				write.print(movie.getDirector() + "; ");
				LOG.info("Adding movie runtime to the file");
				write.print(movie.getRunTime() + "; ");
				LOG.info("Adding movie release to the file");
				write.print(movie.getRelease() + "; ");
				LOG.info("Adding movie due date to the file");
				write.print(movie.getDueDate() + "; ");
				write.println();
			}
		}
		catch(Throwable throwable) {
			LOG.error(throwable);
		}
		finally {
			if(write != null) {
				try {
					LOG.info("trying to close the writer");
					write.close();
				}
				catch(Throwable throwable) {
					LOG.error(throwable);
				}
			}
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
		LOG.info("returning the users choice");
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
				LOG.info("returning the borrowed movie: " + arr[i]);
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
		LOG.info("setting up the movies");
		box.setUpMovies();
		
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
		LOG.info("writing data to the file");
		box.writeDataToFile();
		LOG.info("Exiting program");
		System.out.println("Goodbye!");
	}
}
