package edu.skidmore.cs226.usepatterns;
import java.util.Scanner;
import org.apache.log4j.Logger;
import java.util.Random;
import org.apache.log4j.Logger;



public class SerialNumberGenerator {

	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(SerialNumberGenerator.class);
	}
	/**
	 * Instance of SeriaLNumberGenerator
	 */

	private static SerialNumberGenerator instance;
	/**
	 * lastSerialNumber attribute
	 */
	private long lastSerialNumber;
	
	/**
	 * Method generating a new instance
	 * @return instance
	 */
	public static synchronized SerialNumberGenerator getInstance(){
		LOG.info("Checks if there is an instance of the generator");
		if (instance == null) {

			LOG.info("Creating a new instance");
			instance = new SerialNumberGenerator();
		}
		LOG.info("Returning the instance");
		return instance;
		}

		
	
	/**
	 * Method meant to generate a randomized prefix
	 * @param prefix
	 * @return prefix + rand.nextInt()
	 */
	
	public String generateSerialNumber(String prefix) {
		LOG.debug("Creating the randomized prefix which is currently: " + prefix);
		Random rand = new Random();		
		return prefix + rand.nextInt();
	}
	
	private SerialNumberGenerator(){
		
	}
	
	
}
