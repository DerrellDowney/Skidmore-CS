package edu.skidmore.cs226.usepattern.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;

import org.junit.Test;

import edu.skidmore.cs226.base.Coin;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;
import edu.skidmore.cs226.base.PredefinedMonetaryUnit;
import edu.skidmore.cs226.usepatterns.PhysicalMoneyFactory;

public class PhysicalMoneyFactoryTest {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PhysicalMoneyFactory.class);
	}

	@Test
	public void mintMoneyTest() {
		PhysicalMoneyFactory testFactory = PhysicalMoneyFactory.getInstance();
		LOG.info("Creating an instance of the factory");
		Coin testCoin = new Coin("Dime", 1, null, null);
		Coin[] coinArr = {testCoin};
		assertEquals("Should return a Dime",coinArr[0].getName().toUpperCase(),testFactory.mintMoney(10)[0].getName());
		LOG.info("testing that the correct name is gotten");
		long[] coinArr2 = {50};
		assertEquals("Should return a Half-Dollar",coinArr2[0],testFactory.mintMoney(50)[0].getValueInCents());
		LOG.info("Testing that the correct vaue is gotten");
		int[] testarray = {1,2,3,4,5,6,7,8};
		assertEquals("Should return an array wth length 8",testarray.length,testFactory.mintMoney(99).length);
		LOG.info("Testing that if a value that needs to be broken up is inputted it is done correctly");
		String[] coinArr3 = {"Penny"};
		assertEquals("Should return a Penny",coinArr3[0].toUpperCase(),testFactory.mintMoney(1)[0].getName());
		LOG.info("Testing lower bound");
		String[] coinArr4 = {"DOLLAR_BILL"};
		assertEquals("Should return a DOLLAR_BILL",coinArr4[0].toUpperCase(),testFactory.mintMoney(100)[0].getName());
		LOG.info("Testing lower bound for paper currency");
		String[] coinArr5 = {"TEN_DOLLAR_BILL"};
		assertEquals("Should return a TEN_DOLLAR_BILL",coinArr5[0].toUpperCase(),testFactory.mintMoney(1000)[0].getName());
		LOG.info("Testing upper bound");
		}
	@Test
	public void mintMoneyOverrideTest() {
		LOG.info("Creating an instance of the factory");
		PhysicalMoneyFactory testFactory = PhysicalMoneyFactory.getInstance();
		LOG.info("Creating a list of predefined money values");
		PredefinedMonetaryUnit[] enumMoneyList = PredefinedMonetaryUnit.values();
		LOG.info("Testing lower bound that the correct value is returned");
		assertEquals("Value should be one cent",enumMoneyList[0].getValueInCents(),testFactory.mintMoney(enumMoneyList[0]).getValueInCents());
		LOG.info("Testing upperbound that the correct value is returned");
		assertEquals("Value should be one thousand cents",enumMoneyList[7].getValueInCents(),testFactory.mintMoney(enumMoneyList[7]).getValueInCents());
	}

}
