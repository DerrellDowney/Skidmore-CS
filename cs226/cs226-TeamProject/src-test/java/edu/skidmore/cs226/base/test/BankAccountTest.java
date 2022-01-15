package edu.skidmore.cs226.base.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.base.*;

public class BankAccountTest {
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
    BankAccount bankAccount = new BankAccount(null);
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

        test =
            new Coin("Test Money", 234, frontImage, backImage);
    }
    /**
     * Testing the deposit method in BankAccount
     */
    @Test
    public void testDeposit() {
    	bankAccount.deposit(test);
    	LOG.info("testing if the contents is not null because we deposited test coin");
    	assertNotNull(bankAccount.contents());
    }
    /**
     * Testing the withdraw method in BankAccount
     */
    @Test
    public void testWithdraw() {
    	BankAccount a = new BankAccount(null);
    	bankAccount.deposit(test);
    	bankAccount.withdraw(test);
    	LOG.info("testing if the contents is not null");
    	assertNotNull(bankAccount.contents());
    	LOG.info("testing if contents is equal between two of the same object types");
    	assertEquals(bankAccount.contents(), a.contents());
    }
    /**
     * Testing the contents method in BankAccount
     */
    @Test
    public void testContents() {
    	BankAccount a = new BankAccount(null);
    	LOG.info("testing if the contents is not null");
    	assertNotNull(bankAccount.contents());
    	LOG.info("testing if contents is equal between two of the same object types");
    	assertEquals(bankAccount.contents(), a.contents());
    }
    
    
}
