package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;

/**
 * Unit tests for PhysicalMonetaryUnit class.
 * 
 * @author readda
 */
public class PhysicalMonetaryUnitTest {
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
    private PhysicalMonetaryUnit testInstance;

    /**
     * Static set up.
     */
    static {
        LOG = Logger.getLogger(PhysicalMonetaryUnitTest.class);
    }

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

        testInstance =
            new Coin("Test Money", 234, frontImage, backImage);
    }

    /**
     * Test the getName() method.
     */
    @Test
    public void testGetName() {
        assertEquals("Test Money", testInstance.getName());
    }

    /**
     * Test the setName() method.
     */
    @Test
    public void testSetName() {
        testInstance.setName("New Money Name");
        assertEquals("New Money Name", testInstance.getName());
    }

    /**
     * Test the getValueInCents() method.
     */
    @Test
    public void testGetValueInCents() {
        assertEquals(234, testInstance.getValueInCents());
    }

    /**
     * Test the setValueInCents() method.
     */
    @Test
    public void testSetValueInCents() {
        testInstance.setValueInCents(543);
        assertEquals(543, testInstance.getValueInCents());
    }

    /**
     * Test the getFrontImage() method. This method also verifies that the test
     * environment loaded an image to use in the test.
     */
    @Test
    public void testGetFrontImage() {
        assertNotNull("No image was loaded for the front image", frontImage);
        assertEquals(frontImage, testInstance.getFrontImage());
    }

    /**
     * Test the setFrontImage() method. It sets the front image to be the back
     * image and then verifies that the set call changed the image.
     */
    @Test
    public void testSetFrontImage() {
        testInstance.setFrontImage(backImage);
        assertEquals(backImage, testInstance.getFrontImage());
    }

    /**
     * Test the getBackImage() method. This method also verifies that the test
     * environment loaded an image to use in the test.
     */
    @Test
    public void testGetBackImage() {
        assertNotNull("No image was loaded for the back image", backImage);
        assertEquals(backImage, testInstance.getBackImage());
    }

    /**
     * Test the setBackImage() method. It sets the back image to be the front
     * image and then verifies that the set call changed the image.
     */
    @Test
    public void testSetBackImage() {
        testInstance.setBackImage(frontImage);
        assertEquals(frontImage, testInstance.getBackImage());
    }

    /**
     * Test the hashCode() method. The current design uses the name of the
     * currency for the hashCode calculation and the test for equality.
     */
    @Test
    public void testHashcode() {
        int hashOfText = "Test Money".hashCode();
        assertEquals(hashOfText, testInstance.hashCode());
    }

    /**
     * Test the equals() method given an equivalent object.
     */
    @Test
    public void testEquals() {
        PhysicalMonetaryUnit instance2 =
            new Coin("Test Money", 234, frontImage, backImage);
        assertEquals(testInstance, instance2);
    }

    /**
     * Test the equals() method given a different object.
     */
    @Test
    public void testNotEquals() {
        Object instance2 = new Object();
        assertNotEquals(testInstance, instance2);
    }

}
