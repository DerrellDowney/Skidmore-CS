package edu.skidmore.cs226.usepattern.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.logging.*;

import edu.skidmore.cs226.usepatterns.AccountSetupDependencyInjection;
import edu.skidmore.cs226.usepatterns.RenameableCoinJar;
/**
 * Testing Class for Renameable Coin Jar
 * @author lkeith
 *
 */

public class RenameableCoinJarTest {
	/**
	 * Logger Setup
	 */
	private final static Logger LOG;
	static {
        LOG = Logger.getLogger(AccountSetupDependencyInjection.class);
    }
/**
 * Test for set description 
 * sets description from clear to red
 */
	@Test
	public void setDescriptionTest() {
		RenameableCoinJar testJar = new RenameableCoinJar("Clear");
		LOG.info("Coin jar constructed with clear description");
		testJar.setDescription("Red");
		LOG.info("Coin Jar description set to red");
		assertEquals("Red", testJar.getDescription());
	}
	/**
	 * Test for get description
	 */
	@Test 
	public void getDescriptionTest() {
		RenameableCoinJar testJar = new RenameableCoinJar("Clear");
		LOG.info("Coin jar constructed with clear description");
		testJar.setDescription("Red");
		LOG.info("Coin Jar description set to red");
		assertEquals("Red", testJar.getDescription());
	}

}
