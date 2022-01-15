package edu.skidmore.cs226.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import edu.skidmore.cs226.usepatterns.FedGovNotificationObserver;
import edu.skidmore.cs226.usepatterns.LogTransactionObserver;


/**
 * Represents a container which can hold a set made up of any type of physical
 * monetary units.
 * 
 * Derrell logging this class
 * @author readda
 */
public class CashDrawer extends MoneyHolderImpl<PhysicalMonetaryUnit> {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(CashDrawer.class);
	}
    /**
     * The set of physical monetary units contained in the CashDrawer.
     */
    private List<PhysicalMonetaryUnit> cash;

    /**
     * Create a new (empty) CashDrawer.
     * 
     * @param description
     *            A name for the CashDrawer
     */
    public CashDrawer(String description) {
        super(description);
        LogTransactionObserver lTO = new LogTransactionObserver();
        FedGovNotificationObserver fGNO = new FedGovNotificationObserver();
        attach(lTO);
        attach(fGNO);
        LOG.info("constructing a new cash drawer");
        LOG.debug("assigned the description of the cashdrawer to: " + description);
        cash = new ArrayList<>();
    }

    @Override
    public void deposit(PhysicalMonetaryUnit... income) {
    	LOG.info("depositing money into the cashdrawer");
    	LOG.debug("depositing " + income + " to the cash drawer");
        cash.addAll(Arrays.asList(income));
        CashDrawer cD = new CashDrawer(getDescription());
        notifyObservers(cD, "Deposit", income);
    }

    @Override
    public MonetaryUnit[] withdraw(PhysicalMonetaryUnit... expense) {
        MoneyExtractor<PhysicalMonetaryUnit> extractor = new MoneyExtractor<>();
        LOG.info("withdrawing money from the cashdrawer");
    	LOG.debug("withdrawing " + expense + " from the cash drawer");
        MonetaryUnit[] withdrawal =
            extractor.extractPhysicalMonetaryUnit(cash, expense);
        CashDrawer cD = new CashDrawer(getDescription());
        notifyObservers(cD, "Withdraw", expense);
        return withdrawal;
    }

    @Override
    public PhysicalMonetaryUnit[] contents() {
    	LOG.info("returning the amount of money in the cashdrawer");
    	LOG.debug("returning that there is " + cash.toArray(new PhysicalMonetaryUnit[cash.size()]) + " in the cashdrawer");
        return cash.toArray(new PhysicalMonetaryUnit[cash.size()]);
    }

}
