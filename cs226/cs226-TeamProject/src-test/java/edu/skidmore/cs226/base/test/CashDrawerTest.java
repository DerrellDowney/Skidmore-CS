package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.*;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;

/**
 * Unit tests for CashDrawer
 * @author alawrenc
 * 
 */
public class CashDrawerTest {
	/**
     * The logger.
     */
    static final Logger LOG;

    /**
     * Test front image.
     */
    private Image frontImage;
    /**
     * Test for CashDrawer
     */
    CashDrawer cDrawer = new CashDrawer(null);
    /**
     * Test back image.
     */
    private Image backImage;

    /**
     * The predefined test instance.
     */
    private  PhysicalMonetaryUnit test;

    /**
     * Static set up.
     */
    static {
        LOG = Logger.getLogger(CashDrawerTest.class);
    }
    private List<PhysicalMonetaryUnit> cash;

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
        LOG.info("Creating Coin instance");
        test =
            new Coin("Test Money", 234, frontImage, backImage);
    }
    /**
     * Testing the deposit method
     */
    @Test
    public void testDeposit() {
    	LOG.info("Seeing that deposit works");
    	cDrawer.deposit(test);
    	assertNotNull(cDrawer.contents());
    }
    /**
     * Testing the withdraw method
     */
	@Test
    public void testWidthdraw(){
		cDrawer.deposit(test);
    	cDrawer.withdraw(test);
    	assertNotNull(cDrawer.contents());
    	LOG.debug("Making sure that " + cDrawer.withdraw() + " is correct");
    }
	/**
	 * Testing to see that contents returns the values placed into it
	 */
	@Test
	public void testContentsAccuracy() {
		cDrawer.deposit(test);
		cDrawer.deposit(test);
		cDrawer.deposit(test);
		cDrawer.deposit(test);
		LOG.info("Testing to see that each Coin was deposited into CashDrawer");
		assertNotNull(cDrawer.contents());
	}

}
