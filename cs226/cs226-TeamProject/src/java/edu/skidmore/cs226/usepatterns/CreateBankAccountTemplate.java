package edu.skidmore.cs226.usepatterns;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.BankAccount;

public class CreateBankAccountTemplate {
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateBankAccountTemplate.class);
	}
	
	/**
	 * Opens the bank account, deposits money into account, withdraws money from the account and formats the balance of the account
	 * @param name
	 * @return account
	 */
	public BankAccount openAccount(String name) {
		BankAccount account = new BankAccount(name);
		depositFunds(account);
		withdrawFunds(account);
		formatBalance(account);
		LOG.debug("Creating a new bank account, depositing and withdrawing from: " + account);
		return account;
		
	}
	/**
	 * Deposits funds into the BankAccount
	 * @param account
	 */
	protected void depositFunds(BankAccount account) {
		LOG.info("Method to deposit funds into bank account");
	}
	/**
	 * Withdraws funds into the BankAccount
	 * @param account
	 */
	
	protected void withdrawFunds(BankAccount account) {
		LOG.info("Method to withdraw funds from bank account");
	}/**
	 * Formats the balance within the account to be more user friendly
	 * @param account
	 */
	
	protected String formatBalance(BankAccount account) {
		LOG.info("Method to return bank account balance");
		return "A bank account named " + account.getDescription() + " was created"; 
	}
	
	
}
