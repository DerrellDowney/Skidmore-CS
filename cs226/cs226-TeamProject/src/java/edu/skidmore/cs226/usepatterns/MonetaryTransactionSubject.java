package edu.skidmore.cs226.usepatterns;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.MonetaryUnit;
import edu.skidmore.cs226.base.MoneyHolder;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;

public abstract class MonetaryTransactionSubject implements Observable {
	
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(MonetaryTransactionSubject.class);
	}
	
	private List <MonetaryTransactionObserver> observers;
	
	protected MonetaryTransactionSubject() {
		observers = new ArrayList<>();
	}
	
	protected void notifyObservers(MoneyHolder<? extends MonetaryUnit> source, String transactionType, PhysicalMonetaryUnit... transaction){
		LOG.info("running notifyObservers for transaction: " + transactionType);
		for (MonetaryTransactionObserver observer: observers) {
			observer.update(source, transactionType, transaction);
		}
	}
	
	@Override
	public void attach(MonetaryTransactionObserver o) {
		// TODO Auto-generated method stub
		LOG.info("running attach");
		observers.add(o);
	}

	@Override
	public void detach(MonetaryTransactionObserver o) {
		// TODO Auto-generated method stub
		LOG.info("running detach");
		observers.remove(o);
	}
}
