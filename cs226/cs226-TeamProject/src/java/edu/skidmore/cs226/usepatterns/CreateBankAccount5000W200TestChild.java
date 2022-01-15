package edu.skidmore.cs226.usepatterns;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.BankAccount;
/**
 * Uses the CreateBankAccount template to hardcode values into Bank account
 * @author elephants
 *
 */
public class CreateBankAccount5000W200TestChild extends CreateBankAccountTemplate{
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateBankAccount5000W200.class);
	}
	/**
	 * Deposits $5000 into the bank account
	 * @param account
	 */
	@Override
	public void depositFunds(BankAccount account) {
		PhysicalMoneyFactory factory = PhysicalMoneyFactory.getInstance();
		LOG.info("Depositing $5000 into factory");
		account.deposit(factory.mintMoney(500000));
		LOG.debug("Depositing $5000 to account, value is now" + account.contents());
	}
	/**
	 * Withdraws $200 from the bank account
	 * @param account
	 */
	@Override
	public void withdrawFunds(BankAccount account) {
		PhysicalMoneyFactory factory = PhysicalMoneyFactory.getInstance();
		LOG.info("Withdrawing money from account");
		account.withdraw(factory.mintMoney(20000));
		LOG.debug("Withdrawing $200 from account, value is now" + account.contents());
	}
	/**
	 * Formats the balance of the bank account to be more user friendly
	 */
	@Override
	public String formatBalance(BankAccount account) {
		return "Balance of " +account.getDescription()+" bank account is $4,800";
	}
}
