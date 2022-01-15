package edu.skidmore.cs226.base.test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.MoneyClip;
import edu.skidmore.cs226.base.MoneyHolder;
import edu.skidmore.cs226.base.PaperCurrency;
import org.apache.log4j.Logger;


/**
 * Unit tests for MoneyClip.
 * 
 * @author Liam Keith
 */
public class MoneyClipTest {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MoneyClipTest.class);
	}
	
	/**
     * The predefined test instance.
     */
	private MoneyHolder<PaperCurrency> testInstance;
	private PaperCurrency testMoney;
	/**
     * Create the test instance before each test is run.
     */
	@Before
	public void setUp() {
		LOG.info("Setting up the test money clip and paper currency");
		testInstance = new MoneyClip("red");
	    BufferedImage frontImage = null;
		BufferedImage backImage = null;
		try {
	        frontImage =
	            ImageIO.read(getClass().getResource("test-money-front.jpg"));
	        backImage =
	            ImageIO.read(getClass().getResource("test-money-back.jpg"));
	    } catch (Throwable t) {
            LOG.warn("Unable to load test image", t);
        }
	    testMoney =
	        new PaperCurrency("Test Money", 234, frontImage, backImage, "1234");
	}

	/**
	 * Testing the deposit(PaperCurrency... income) method
	 */
	@Test
	public void testDeposit() {
		LOG.info("Testing the deposit method");
		testInstance.deposit(testMoney);
        assertNotNull(testInstance.contents());
	}
	@Test
	public void testWithdraw() {
		LOG.info("Testing the withdraw method");
		MoneyClip testInstance2 = new MoneyClip("red");
		testInstance.deposit(testMoney);
		testInstance.withdraw(testMoney);
		assertEquals(testInstance2.contents(), testInstance.contents());
	}
	@Test
	public void testContents() {
		LOG.info("Testing the contents method");
		testInstance.deposit(testMoney);
		testInstance.deposit(testMoney);
		testInstance.deposit(testMoney);
		testInstance.deposit(testMoney);
		testInstance.deposit(testMoney);
        assertNotNull(testInstance.contents());


	}
	
	

}
