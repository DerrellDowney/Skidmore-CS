package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.PredefinedMonetaryUnit;

public class PredefinedMonetaryUnitTest {

	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PredefinedMonetaryUnitTest.class);
	}
    
    /**
     * The predefined test instance.
     */
    private PredefinedMonetaryUnit testInstance;
    
    /**
     * Create the test instance before each test is run, and set it to DIME
     */
    @Before
    public void setUp() {
    	LOG.info("calling setUP that creates a testInstace of PredefinedMonetaryUnit.DIME");
        testInstance = PredefinedMonetaryUnit.DIME;
    }
    
    /**
     * testing getName given DIME
     */
	@Test
	public void testGetName() {
		LOG.info("testing the getName method");
		assertEquals("Dime", testInstance.getName());
	}
	
	/**
	 * testing getValueInCents given DIME
	 */
	@Test
	public void testGetValueInCents() {
		LOG.info("testing the getName method");
		assertEquals(10, testInstance.getValueInCents());
	}
	
	/**
	 * testing isCoin given DIME
	 */
	@Test
	public void testIsCoin() {
		LOG.info("testing the getName method");
		assertEquals(true, testInstance.isCoin());
	}
	
	/**
	 * testing getFrontImage given DIME
	 */
	@Test
	public void testGetFrontImage() {
		LOG.info("testing the getName method");
		assertEquals(null, testInstance.getFrontImage());
	}
	
	/**
	 * testing getBackImage given DIME
	 */
	@Test
	public void testGetBackImage() {
		LOG.info("testing the getName method");
		assertEquals(null, testInstance.getBackImage());
	}
	
}
