package edu.skidmore.cs226.usepattern.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.log4j.Logger;
import edu.skidmore.cs226.base.CashDrawer;
import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.CoinJar;
import edu.skidmore.cs226.base.MoneyClip;
import edu.skidmore.cs226.usepatterns.CreateFilledMoneyHolderFacade;

/**
 * 
 * @author Elephants
 * Unit test for CreateFilledMoneyHolderFacade
 */
public class CreateFilledMoneyHolderFacadeTest {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(CreateFilledMoneyHolderFacadeTest.class);
	}

	/**
	 * Test it makes only one instance
	 * test that the right amount is being put in the holders
	 * test that the right amount is being put in the holders with the smallest amount of physical currency
	 * test that the exception is thrown 
	 * test that the description is being set
	 * 
	 */
	
	 /**
	  * getInstanceTest() simply tests that the get instance method gets an instance and that it gets the same instance
	  */
	@Test
	public void getInstanceTest() {
		LOG.info("calling getInstanceTest");
		CreateFilledMoneyHolderFacade newFacade = CreateFilledMoneyHolderFacade.getInstance();
		assertNotNull(newFacade);
		CreateFilledMoneyHolderFacade testFacade = CreateFilledMoneyHolderFacade.getInstance();
		assertEquals(testFacade, newFacade);
	}
	/**
	 * makeCashDrawerTest creates a cash drawer, inputs amounts of money 
	 */
	@Test
	public void makeCashDrawerTest() {
		LOG.info("calling makeCashDrawerTest");
		CreateFilledMoneyHolderFacade testFacade = CreateFilledMoneyHolderFacade.getInstance();
		CashDrawer testDrawer = testFacade.makeCashDrawer("Red", 1000);
		assertEquals(1, testDrawer.contents().length);
		assertEquals(1000, testDrawer.contents()[0].getValueInCents());
		assertEquals("Red", testDrawer.getDescription());
	}
	
	/**
	 * makeCoinJarTest tests makeCoinJar with depositing different values
	 */
	@Test 
	public void makeCoinJarTest() {
		LOG.info("calling makeCoinJarTest");
		CreateFilledMoneyHolderFacade testFacade = CreateFilledMoneyHolderFacade.getInstance();
		LOG.info("Running coin jar test");
		CoinJar testJar = testFacade.makeCoinJar("Clear", 12);
		assertEquals(5,testJar.contents().length);
		assertEquals(testJar.getDescription(), "Clear");
		CoinJar testJar2 = testFacade.makeCoinJar("Clear", 100);
		assertEquals(3, testJar2.contents().length);
	}
	
	/**
	 * makeMoneyClipTest tests makeMoneyClip by depositing different values
	 * and testing if you attempt to deposit an invalid amount
	 */
	@Test 
	public void makeMoneyClipTest() {
		LOG.info("calling makeMoneyClipTest");
		CreateFilledMoneyHolderFacade testFacade = CreateFilledMoneyHolderFacade.getInstance();
		MoneyClip testClip = testFacade.makeMoneyClip("Silver", 100);
		assertEquals(1,testClip.contents().length);
		assertEquals("Silver", testClip.getDescription());
		assertEquals(100, testClip.contents()[0].getValueInCents());
		
		//assertThrows(IllegalArgumentException.class,()->{
		//MoneyClip testClipInvalidAmount = testFacade.makeMoneyClip("gold", 153);
		//});
	}

}
