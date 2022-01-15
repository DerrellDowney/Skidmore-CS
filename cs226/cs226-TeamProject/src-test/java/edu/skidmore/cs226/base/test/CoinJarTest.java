package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.*;


public class CoinJarTest {
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
    CoinJar coinJar = new CoinJar(null);
    /**
     * Test back image.
     */
    private Image backImage;

    /**
     * The predefined test instance.
     */
    private Coin testCoin;

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
    	
    	LOG.info("creating a Coin");
        try {
            frontImage =
                ImageIO.read(getClass().getResource("test-money-front.jpg"));
            backImage =
                ImageIO.read(getClass().getResource("test-money-back.jpg"));
        }
        catch (Throwable t) {
            LOG.warn("Unable to load test image", t);
        }

        testCoin =
            new Coin("Test Money", 234, frontImage, backImage);
    }
    
    /**
     * Testing the isOpen method of the CoinJar
     */
    @Test
    public void testIsOpen() {
    	LOG.info("Testing the isOpen method of the CoinJar");
    	coinJar.isOpen();
    	assertFalse(coinJar.isOpen());
    }
    
    /**
     * Testing the close method of the CoinJar
     */
    @Test
    public void testClose() {
    	LOG.info("Testing the close method of the CoinJar");
    	coinJar.close();
    	assertEquals(false, coinJar.isOpen());
    }
    
    /**
     * Testing the open method of the CoinJar
     */
    @Test
    public void testOpen() {
    	LOG.info("Testing the open method of the CoinJar");
    	coinJar.open();
    	assertEquals(true, coinJar.isOpen());
    }
    
    /**
     * Testing the deposit method of the CoinJar
     */
    @Test
    public void testDeposit() {
    	LOG.info("Testing the deposit method of the CoinJar");
    	coinJar.open();
    	LOG.info("depositing a coin into the jar");
    	coinJar.deposit(testCoin);
    	assertNotNull(coinJar.contents());
    }
    
    /**
     * Testing the withdraw method of the CoinJar
     */
    @Test
    public void testWithdraw(){
    	LOG.info("Testing the withdraw method of the CoinJar");
    	coinJar.open();
    	coinJar.deposit(testCoin);
    	LOG.info("withdrawing a coin");
    	coinJar.withdraw(testCoin);
    	assertNotNull(coinJar.contents());
    }
    
    /**
     * Testing the contents method of the CoinJar
     */
    @Test
    public void testContents() {
    	CoinJar a = new CoinJar(null);
    	LOG.info("testing if the contents is not null");
    	assertNotNull(coinJar.contents());
    	LOG.info("testing if contents is equal between two of the same object types");
    	assertEquals(coinJar.contents(), a.contents());
    }
}
