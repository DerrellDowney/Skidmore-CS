package edu.skidmore.cs226.usepattern.test;


import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.log.Log;
import edu.skidmore.cs226.base.BankAccount;
import edu.skidmore.cs226.usepatterns.CreateBankAccount5000W200TestChild;
import edu.skidmore.cs226.usepatterns.CreateBankAccountTemplate;

/**
 * Tester class to check the methods in CreateBankAccount5000W200
 * Will check deposit, withdraw and the formatBalance methods
 * @author elephants
 *
 */
public class CreateBankAccount5000W200Test {
	
	
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateBankAccount5000W200Test.class);
	}
	/**
	 * Tests deposit method to ensure that when something is deposited contents is not null
	 */
	@Test
	public void testDeposit() {
		CreateBankAccount5000W200TestChild createConAcc = new CreateBankAccount5000W200TestChild();
		BankAccount acc = createConAcc.openAccount("a");
		createConAcc.depositFunds(acc);		assertNotNull(acc.contents());
	}
	/**
	 * Tests deposit method to ensure that when something is withdrawn, contents is not null
	 */
	@Test
	public void testWithdraw() {
		CreateBankAccount5000W200TestChild createConAcc = new CreateBankAccount5000W200TestChild();
		BankAccount acc = createConAcc.openAccount("a");
		createConAcc.withdrawFunds(acc);
		assertNotNull(acc.contents());
	}
	/**
	 * Tests to see that the balance is formatted correctly
	 */
	@Test
	public void testFormatBalance() {
		CreateBankAccount5000W200TestChild createConAcc = new CreateBankAccount5000W200TestChild();
		BankAccount acc = createConAcc.openAccount("a");
		assertEquals("Balance of a bank account is $4,800", createConAcc.formatBalance(acc));
	}
}
