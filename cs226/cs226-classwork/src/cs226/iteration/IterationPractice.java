package cs226.iteration;

import java.util.Scanner;

public class IterationPractice {
	/**
	 * Create a method returning the sum of user inputs
	 * Will end when 0 is entered
	 */
	public double userSum() {
		Scanner keyboard = new Scanner(System.in);
		double userInput = -1;
		double current = 0;
		
		while (userInput != 0 ) {
			System.out.println("Please give a number from 0 to end");
			userInput = keyboard.nextDouble();
			current = current + userInput;
		}
		return current;
	}
	
	/**
	 * same as previous method except with a do while loop
	 * 
	 */
	public double userSumDoWhile() {
		Scanner keyboard = new Scanner(System.in);
		double userInput = -1;
		double current = 0;
		
		do{
			System.out.println("Please give a number from 0 to end");
			userInput = keyboard.nextDouble();
			current = current + userInput;
		}while (userInput != 0 ); 
			
		
		return current;
	}
	
	/**
	 * Add up positive numbers - end when 0 is typed
	 * use do/while and continue
	 */
	public double addPositives() {
		Scanner keyboard = new Scanner(System.in);
		double userInput;
		double sum = 0;
		do {
			System.out.println("enter a positive number (type 0 to exit)");
			userInput = keyboard.nextDouble();
			if (userInput < 0) {
				System.out.println("number is not positive; will not be added");
				continue;
			}
			
		} while (userInput != 0);
		return sum;
	}
	
	/**
	 * Will take input from the user and add the numbers and the amount of numbers
	 * Then return the mean of the numbers
	 */
	public double userMean() {
		Scanner keyboard = new Scanner(System.in);
		double userInput = -1;
		double current = 0;
		int counter = -1;
		
		while (userInput != 0 ) {
			System.out.println("Please give a number from 0 to end");
			userInput = keyboard.nextDouble();
			current = current + userInput;
			counter++;
		}
		return current/counter;
		
	}
	
	/**
	 * want to print numbers 1-5 using a for loop
	 */
	public void createNumbers() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i+1);
		}
	}
	
	/**
	 * Prints numbers 10 through 50 
	 * count by 5
	 */
	public void countBy5() {
		for (int i = 10; i <= 50; i = i+5) {
			System.out.println(i);
		}
	}
	
	/**
	 * Prints letters A-E on the screen one letter per row
	 */
	public void showLetters() {
		for (char i = 'A'; i <= 'E'; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * Loop through String, display each character as its own line
	 */
	public void printLetters(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		IterationPractice test = new IterationPractice();
		double answer = test.userSum();
		System.out.println("The sum is " + answer);
		double mean = test.userMean();
		System.out.println("The mean is " + mean);
		
		System.out.println("---------------");
		test.countBy5();
		System.out.println("---------------");
		test.showLetters();
		System.out.println("---------------");
		test.printLetters("Skidmore");

	}
}
