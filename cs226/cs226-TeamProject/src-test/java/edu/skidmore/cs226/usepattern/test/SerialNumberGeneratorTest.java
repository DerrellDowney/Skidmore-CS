package edu.skidmore.cs226.usepattern.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.apache.log4j.Logger;
import org.junit.Test;
import edu.skidmore.cs226.usepatterns.SerialNumberGenerator;


public class SerialNumberGeneratorTest {

	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(SerialNumberGeneratorTest.class);
	}
	
	/**
	 * Instance of SerialNumberGenerator
	 */
	public SerialNumberGenerator test = SerialNumberGenerator.getInstance();
	
	
	/**
	 * Testing the GenerateSerialNumber method
	 */
	@Test
	public void testGenerateSerialNumber() {
		LOG.info("testing the generateSerialNumber method");
		String testString = test.generateSerialNumber("asd");
		assertNotNull(testString);
	}

	/**
	 * Testing the getInstansce method
	 */
	@Test
	public void testGetInstanceNull() {
		LOG.info("testing the getInstance method with a null");
		SerialNumberGenerator nullTest = SerialNumberGenerator.getInstance();
		assertNotNull(nullTest.getInstance());
	}
	/**
	 * Testing the getInstansce method
	 */
	@Test
	public void testGetInstanceSame() {
		LOG.info("testing the getInstance method with a null");
		SerialNumberGenerator nullTest = SerialNumberGenerator.getInstance();
		SerialNumberGenerator null2 = SerialNumberGenerator.getInstance();
		assertEquals("Returned 2 different instances",nullTest,null2);
	}
	
	
}
