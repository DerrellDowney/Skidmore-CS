package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;

import java.awt.Image;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.PaperCurrency;

/**
 * 
 * @author rpepin
 *	A test class for the PaperCurrencyTest 
 */
public class PaperCurrencyTest {

	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PaperCurrencyTest.class);
	}
	
    /**
     * Test front image.
     */
    private Image frontImage;

    /**
     * Test back image.
     */
    private Image backImage;
    
    /**
     * The predefined test instance.
     */
    private PaperCurrency testInstance;
    
    
    /**
     * Create the test instance before each test is run.
     */
    @Before
    public void setUp() {
        try {
            frontImage =
                ImageIO.read(getClass().getResource("test-money-front.jpg"));
            backImage =
                ImageIO.read(getClass().getResource("test-money-back.jpg"));
        }
        catch (Throwable t) {
            LOG.warn("Unable to load test image", t);
        }
        
        testInstance = new PaperCurrency("Dollar",100,frontImage,backImage,"red1");

    }
	
    /**
     * Testing the setSerialNumber method and thus the getSerialNumber method by proxy
     */
	@Test
	public void testSetSerialNumber() {
		LOG.info("testing the setSerialNumber method");
		testInstance.setSerialNumber("red2");
		assertEquals("red2", testInstance.getSerialNumber());
	}
	
	/**
	 * Testing the toString method for paperCurrency it should just return the name of the paperCurrency
	 */
	@Test
	public void testToString() {
		LOG.info("testing toString mehtod for Paper Currency");
		assertEquals("Dollar", testInstance.toString());
	}
	
	
	
	
}
