package edu.skidmore.cs226.usepattern.test;


import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.log.Log;

import edu.skidmore.cs226.base.BankAccount;
import edu.skidmore.cs226.usepatterns.CreateBankAccount5000W200;
import edu.skidmore.cs226.usepatterns.CreateBankAccountTemplate;

/**
 * Test class for CreateBankAccountTemplate
 * Will test the openAccount and formatBalance methods
 * @author Elephants
 *
 */
public class CreateBankAccountTemplateTest extends CreateBankAccountTemplate{
	
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateBankAccountTemplateTest.class);
	}
	/**
	 * Tests openAccount to ensure that when opened, a bank account instance is created and not null
	 */
	@Test
	public void testOpenAccount() {
		BankAccount acc = openAccount("a");
		assertNotNull(acc);
	}
	/**
	 * Tests formatBalance
	 * Ensures that the formatting produces the correct format.
	 */
	@Test
	public void testFormatBalance() {
		BankAccount acc = openAccount("a");
		assertEquals("A bank account named " + acc.getDescription() + " was created",formatBalance(acc));
	}
	
	
}
