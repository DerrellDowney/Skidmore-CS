package edu.skidmore.cs226.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import edu.skidmore.cs226.usepatterns.FedGovNotificationObserver;
import edu.skidmore.cs226.usepatterns.LogTransactionObserver;
/**
 * Represents a container which can hold a set made up of only PaperCurrency.
 * 
 * @author readda
 * logger Liam keith
 */
public class MoneyClip extends MoneyHolderImpl<PaperCurrency> {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MonetaryUnit.class);
	}
    /**
     * The set of PaperCurrency in the MoneyClip.
     */
    private List<PaperCurrency> bills;

    /**
     * Create a MoneyClip instance.
     * 
     * @param description
     *            A description for the MoneyClip
     */
    public MoneyClip(String description) {
        super(description);
        LogTransactionObserver lTO = new LogTransactionObserver();
        FedGovNotificationObserver fGNO = new FedGovNotificationObserver();
        attach(lTO);
        attach(fGNO);
        LOG.info("constructs a money clip");
        bills = new ArrayList<>();
    }

    @Override
    public void deposit(PaperCurrency... income) {
    	LOG.warn("Only accepts bills");
        bills.addAll(Arrays.asList(income));
        MoneyClip mC = new MoneyClip(getDescription());
        notifyObservers(mC, "Deposit", income);
    }

    @Override
    public MonetaryUnit[] withdraw(PaperCurrency... expense) {
        MoneyExtractor<PaperCurrency> extractor = new MoneyExtractor<>();
        MonetaryUnit[] withdrawal =
            extractor.extractPaperCurrency(bills, expense);
        LOG.trace(withdrawal + " is withdrawn");
        LOG.trace(expense + " is supposed to be withdrawn");
        MoneyClip mC = new MoneyClip(getDescription());
        notifyObservers(mC, "Withdraw", expense);
        return withdrawal;
        
    }

    @Override
    public PaperCurrency[] contents() {
    	LOG.info("returns the contents of the moneyclip");
        return bills.toArray(new PaperCurrency[bills.size()]);
    }
}
