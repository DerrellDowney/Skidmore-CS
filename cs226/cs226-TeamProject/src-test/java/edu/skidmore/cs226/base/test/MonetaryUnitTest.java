package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.BankAccount;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.MonetaryUnit;

/**
 * Unit tests for MonetaryUnit.
 * 
 * @author readda
 */
public class MonetaryUnitTest {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(MonetaryUnitTest.class);
	}
    /**
     * The predefined test instance.
     */
    private MonetaryUnit testInstance;

    /**
     * Create the test instance before each test is run.
     */
    @Before
    public void setUp() {
    	LOG.info("Setting up test coin");
        testInstance = new Coin("Test Name", 123, null, null);
    }

    /**
     * Test the getName() method.
     */
    @Test
    public void testGetName() {
    	LOG.info("Testing get nema method");
        assertEquals("Test Name", testInstance.getName());
    }

    /**
     * Test the setName() method.
     */
    @Test
    public void testSetName() {
    	LOG.info("Testing set name method");
        testInstance.setName("Changed Name");
        assertEquals("Changed Name", testInstance.getName());
    }

    /**
     * Test the getValueInCents() method.
     */
    @Test
    public void testGetValueInCents() {
    	LOG.info("Testing get value method");
        assertEquals(123, testInstance.getValueInCents());
    }

    /**
     * Test the setValueInCents() method.
     */
    @Test
    public void testSetValueInCents() {
    	LOG.info("Testing set value in cents method");
        testInstance.setValueInCents(321);
        assertEquals(321, testInstance.getValueInCents());
    }
}
