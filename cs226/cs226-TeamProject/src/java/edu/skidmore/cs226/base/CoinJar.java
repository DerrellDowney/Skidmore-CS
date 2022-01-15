package edu.skidmore.cs226.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import edu.skidmore.cs226.usepatterns.FedGovNotificationObserver;
import edu.skidmore.cs226.usepatterns.LogTransactionObserver;


/**
 * Represents a container which can hold a set made up of only Coins.
 * Derrell logging this class
 * @author readda
 */
public class CoinJar extends MoneyHolderImpl<Coin> {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(CoinJar.class);
	}

    /**
     * The set of Coins contained in the CoinJar.
     */
    private List<Coin> coins;

    /**
     * Whether the coin jar is open or not. COins may not be removed or added if
     * the coin jar is not open.
     */
    private boolean open;

    /**
     * Create a CoinJar instance.
     * 
     * @param description
     *            A name for the CoinJar
     */
    public CoinJar(String description) {
        super(description);
        LogTransactionObserver lTO = new LogTransactionObserver();
        FedGovNotificationObserver fGNO = new FedGovNotificationObserver();
        attach(lTO);
        attach(fGNO);
        LOG.info("constructing a new coinjar");
        LOG.debug("assigning " + description + "to the coinjar");
        coins = new ArrayList<>();
    }

    /**
     * Check if the coin jar is open.
     * 
     * @see #close()
     * @see #open()
     * @return True if open, false otherwise
     */
    public boolean isOpen() {
    	LOG.info("checking if the coin jar is open");
        return open;
    }

    /**
     * Close the coin jar.
     * 
     * @see #isOpen()
     * @see #open()
     */
    public void close() {
    	LOG.info("closing the coin jar");
        open = false;
    }

    /**
     * Open the coin jar.
     * 
     * @see #isOpen()
     * @see #close()
     */
    public void open() {
    	LOG.info("opening the coin jar");
        open = true;
    }

    @Override
    public void deposit(Coin... income) {
        if (isOpen()) {
        	LOG.info("depositing coins in the coinjar");
        	LOG.debug("depositing " + income + " to the coin jar");
            coins.addAll(Arrays.asList(income));
        } else {
        	LOG.fatal("cannot deposit money the coin jar is closed");
            throw new IllegalStateException("The coin jar is closed");
        }
        CoinJar cj = new CoinJar(getDescription());
        notifyObservers(cj, "Deposit", income);
    }

    @Override
    public MonetaryUnit[] withdraw(Coin... expense) {
    	CoinJar cj = new CoinJar(getDescription());
        notifyObservers(cj, "Withdraw", expense);
        if (isOpen()) {
        	LOG.info("withdrawing coins from the coinjar");
        	LOG.debug("withdrawing " + expense + " to the coin jar");
            MoneyExtractor<Coin> extractor = new MoneyExtractor<>();
            MonetaryUnit[] withdrawal = extractor.extractCoins(coins, expense);
            return withdrawal;
        } else {
        	LOG.error("cannot withdraw coins the jar is closed");
            throw new IllegalStateException("The coin jar is closed");
        }
        
    }

    @Override
    public Coin[] contents() {
    	LOG.info("returning the amount in the coinjar");
        return coins.toArray(new Coin[coins.size()]);
    }
}
