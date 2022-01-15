package edu.skidmore.cs226.lab05indiv;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * A basic calculator. Uses the Operations class to carry out the requested
 * operations.
 * 
 * You are not responsible for creating unit tests for this class.
 * 
 * @author readda
 * 
 * @see Operations
 */
public class Calculator {
	/**
	 * The logger.
	 */
	private final static Logger LOG;

	/**
	 * The keyboard.
	 */
	private Scanner keyboard;

	/**
	 * The library of operations.
	 */
	private Operations ops;

	/**
	 * Set up the logger
	 */
	static {
		LOG = Logger.getLogger(Calculator.class);
	}

	/**
	 * Create the calculator instance. Sets up the Scanner and Operations objects.
	 */
	public Calculator() {
		LOG.info("Calculator instance created");
		keyboard = new Scanner(System.in);
		ops = new Operations();
	}

	/**
	 * Display the menu of calculator options to the user.
	 */
	public void showMenu() {
		LOG.debug("Displaying the menu");
		System.out.println();
		System.out.println("Calculator: choose your operation");
		System.out.println("A - add");
		System.out.println("S - subtract");
		System.out.println("M - multiply");
		System.out.println("O - ordinal");
	}

	/**
	 * Get the user's choice of option.
	 * 
	 * @return The chosen option
	 */
	public char getChoice() {
		char choice;
		
		LOG.trace("Waiting for user to enter a choice");
		System.out.print("Choice? ");
		choice = keyboard.nextLine().toUpperCase().charAt(0);

		LOG.debug("User chose option: " + choice);
		
		return choice;
	}

	/**
	 * Get the values to be used in the calculation.
	 * 
	 * @return The values entered by the user
	 */
	public int[] getValues() {
		System.out.println("How many values will you enter?");
		int numValues = keyboard.nextInt();

		LOG.debug("Number of values to enter: " + numValues);
		
		int[] values = new int[numValues];
		for (int i = 0; i < numValues; ++i) {
			System.out.println("Number " + (i + 1) + "?");
			values[i] = keyboard.nextInt();
		}

		return values;
	}

	/**
	 * Run the calculator:
	 * 
	 * 1. show the menu
	 * 
	 * 2. get the user's choice of operation
	 * 
	 * 3. get the values
	 * 
	 * 4. call the method to do the calculation
	 * 
	 * 5. display the results
	 */
	public void run() {
		LOG.debug("Running the calculator");
		
		showMenu();

		char choice = getChoice();

		int[] numbers = getValues();

		String result;
		String label;

		switch (choice) {
		case 'A':
			result = "" + ops.sum(numbers);
			label = "sum";
			break;
		case 'S':
			int[] remainingNumbers = new int[numbers.length - 1];
			for (int i = 1; i < numbers.length; ++i) {
				remainingNumbers[i - 1] = numbers[i];
			}
			result = "" + ops.diff(numbers[0], remainingNumbers);
			label = "difference";
			break;
		case 'M':
			result = "" + ops.product(numbers);
			label = "product";
			break;
		case 'O':
			result = "";
			for (int num : numbers) {
				result += "\n" + ops.getOrdinalName(num) + ",";
			}
			if (result.length() > 0) {
				result = result.substring(0, result.length() - 1);
			}
			label = "ordinals";
			break;
		default:
			result = "0";
			label = "undefined operation";
		}

		System.out.println("The " + label + " of the numbers: " + result);
	}

	/**
	 * Create the Calculator object and call the run method.
	 * 
	 * @param args Command line arguments - not used.
	 */
	public static void main(String[] args) {
		new Calculator().run();
		LOG.debug("Calculator program finished");
	}

}
