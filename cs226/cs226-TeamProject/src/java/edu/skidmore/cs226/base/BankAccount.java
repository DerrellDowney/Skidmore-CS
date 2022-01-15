package edu.skidmore.cs226.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import edu.skidmore.cs226.usepatterns.FedGovNotificationObserver;
import edu.skidmore.cs226.usepatterns.LogTransactionObserver;


/**
 * Represents a bank account.
 * 
 * Derrell logging this class
 * @author readda
 */
public class BankAccount extends MoneyHolderImpl<PhysicalMonetaryUnit> {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(BankAccount.class);
	}
    /**
     * The set of physical monetary units contained in the CashDrawer.
     */
    private List<PhysicalMonetaryUnit> account;

    /**
     * Create a new (empty) CashDrawer.
     * 
     * @param description
     *            A name for the CashDrawer
     */
    public BankAccount(String description) {
        super(description);
        LogTransactionObserver lTO = new LogTransactionObserver();
        FedGovNotificationObserver fGNO = new FedGovNotificationObserver();
        attach(lTO);
        attach(fGNO);
        LOG.info("constructing a new bank account");
        LOG.debug("assigned the description of the bank account to: " + description);
        account = new ArrayList<>();
    }
    /**
     * Deposit's amoubt into the bank account
     * @param income
     * 			The income amount from the physicalmonetaryunit class
     */

    @Override
    public void deposit(PhysicalMonetaryUnit... income) {
    	LOG.info("depositing money into the bank account");
    	LOG.debug("depositing " + income + " to the bank account");
        account.addAll(Arrays.asList(income));
        BankAccount bA = new BankAccount(getDescription());
        notifyObservers(bA,"Deposit",income);
    }
    /**
     * Withdraws a certain amount from the bank account
     * @param expense
     * 			The withdrawn amount from the physicalmonetaryunit class
     */
    @Override
    public MonetaryUnit[] withdraw(PhysicalMonetaryUnit... expense) {
        MoneyExtractor<PhysicalMonetaryUnit> extractor = new MoneyExtractor<>();
        LOG.info("withdrawing money from the bank account");
    	LOG.debug("withdrawing " + expense + " from the bank account");
        MonetaryUnit[] withdrawal =
            extractor.extractPhysicalMonetaryUnit(account, expense);
        BankAccount bA = new BankAccount(getDescription());
        notifyObservers(bA,"Withdraw",expense);
        return withdrawal;
    }
    
    /**
     * Displays the amount of money currently in the bank account
     * 
     */
    @Override
    public PhysicalMonetaryUnit[] contents() {
    	LOG.info("returning the amount of money in the bank account");
    	LOG.debug("returning that there is " + account.toArray(new PhysicalMonetaryUnit[account.size()]) + " in the bank account");
        return account.toArray(new PhysicalMonetaryUnit[account.size()]);
    }

}
