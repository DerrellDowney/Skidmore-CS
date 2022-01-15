package edu.skidmore.cs226.lab04;

import org.apache.log4j.Logger;

/**
 * A trivial program demonstrating basic use of logging.
 */
public class LoggingExample {
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;

	/**
	 * An attribute of the class.
	 */
	private String description;

	/**
	 * A static block is used to code that should run BEFORE any objects of the
	 * class are created. It will only run once. Typically it is used to initialize
	 * class-level variables.
	 */private static final Logger LOG;

		static {
			LOG = Logger.getLogger(Movie.class);
		}
	static {
		LOG = Logger.getLogger(LoggingExample.class);
	}

	/**
	 * Constructor - creates the object and sets the description attribute to the
	 * supplied value.
	 * 
	 * @param theValue The value to assign to the description.
	 */
	public LoggingExample(String theValue) {
		LOG.info("Create instance value: " + theValue);
		description = theValue;
	}

	/**
	 * Get the length of the description.
	 * 
	 * @return The description length
	 */
	public int getValueLength() {
		LOG.trace("getValueLength called for instance with value: " + description);

		int length = description.length();

		LOG.debug("getValueLength: " + description + " has length " + length);

		return length;
	}

	/**
	 * Set the description text.
	 * 
	 * @param newValue The new description
	 */
	public void setDescription(String newValue) {
		LOG.debug("Changing value from " + description + " to " + newValue);
		description = newValue;
	}

	/**
	 * Get the description.
	 * 
	 * @return The description
	 */
	public String getDescription() {
		LOG.trace("get the description: " + description);
		return description;
	}

	/**
	 * Create instances and call methods.
	 * 
	 * @param args Command line - not used
	 */
	public static void main(String[] args) {
		LoggingExample logExample = new LoggingExample("Analog clock");
		LoggingExample logExample2 = new LoggingExample("Light switch");

		System.out.println("Value length for logExample: " + logExample.getValueLength());

		logExample2.setDescription("Traffic light");

		System.out.println("Value for logExample2: " + logExample2.getDescription());
		System.out.println("Value length for logExample2: " + logExample2.getValueLength());
	}
}
