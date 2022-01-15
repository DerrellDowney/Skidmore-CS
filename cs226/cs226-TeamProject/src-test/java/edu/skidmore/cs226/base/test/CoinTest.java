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


public class CoinTest {
	/**
     * The logger.
     */
    static final Logger LOG;

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
    private  Coin test;

    /**
     * Static set up.
     */
    static {
        LOG = Logger.getLogger(CoinTest.class);
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
     * Testing getHeadsImage and making sure that the value set is there
     */
    @Test
    public void testgetHeadsImageAccuracy() {
    	LOG.info("Seeing if getheadsImage works");
    	assertEquals(frontImage,test.getFrontImage());
    }
    /**
     * Testing setHeadsImage and making sure that the value set is there
     */
    @Test
    public void testsetHeadsImageAccuracy() {
    	test.setFrontImage(backImage);
    	LOG.info("Seeing if setheadsImage returns correct value");
    	assertEquals(backImage,test.getFrontImage());
    }
    /**
     * Testing getTailsImage and making sure that the value set is there
     */
    @Test
    public void testgetTailsImageAccuracy() {
    	LOG.info("Seeing if getTailsImage works");
    	assertEquals(backImage,test.getBackImage());
    }
    /**
     * Testing setTailsImage and making sure that the value set is there
     */
    @Test
    public void testsetTailsImageAccuracy() {
    	test.setBackImage(frontImage);
    	LOG.info("Seeing if setTailsImage returns correct value");
    	assertEquals(frontImage,test.getBackImage());
    }
    /**
     * Testing the flip method
     */
    @Test
    public void testFlipDoesSomething() {
    	test.flip();
    	test.flip();
    	boolean flipper = false;
    	LOG.info("Seeing if flip returns correct value and that it does something");
    	assertEquals(flipper,test.isHeadsUp());
    }
    /**
     * Testing isHeadsUp method to make sure it returns something
     * Also checks to see that flip method occurred.
     */
    @Test
    public void testIsHeadsDoesSomething() {
    	test.flip();
    	boolean flipped = true;
    	LOG.info("Seeing if isHeads returns correct value");
    	assertEquals(flipped, test.isHeadsUp());
    }
    /**
     * Testing to see if the upside image is returned in upSideImage
     */
    @Test
    public void testUpSideImageAccuracy() {
    	test.upSideImage();
    	LOG.info("Seeing if upSide returns correct value");
    	assertEquals(backImage,test.upSideImage());
    }
}
