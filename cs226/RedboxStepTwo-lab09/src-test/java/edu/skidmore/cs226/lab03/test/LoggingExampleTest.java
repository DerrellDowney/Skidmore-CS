package edu.skidmore.cs226.lab03.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.lab04.LoggingExample;

/**
 * Unit tests for the LoggingExample class.
 */
public class LoggingExampleTest {
	/**
	 * A test object.
	 */
	private LoggingExample testObject;

	/**
	 * Setup the test object with an initial value.
	 */
	@Before
	public void setup() {
		testObject = new LoggingExample("Test value");
	}

	/**
	 * Test the initial value set by the constructor.
	 */
	@Test
	public void testInitialDescription() {
		assertEquals("Incorrect description", "Test value", testObject.getDescription());
	}

	/**
	 * Test the setDescription() method.
	 */
	@Test
	public void testSetDescription() {
		testObject.setDescription("A different value");
		assertEquals("Incorrect updated desccription", "A different value", testObject.getDescription());
	}
}
