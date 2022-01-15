package edu.skidmore.cs226.usepatterns;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.MonetaryUnit;
import edu.skidmore.cs226.base.MoneyHolder;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;

public class FedGovNotificationObserver implements MonetaryTransactionObserver {

	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(FedGovNotificationObserver.class);
	}
	
	/**
	 * Notifies the federal government when 10000000 or more is deposited or withdrawn
	 * @param source
	 * 			Where the money is coming from 
	 * @param transactionType
	 * 				The type of transaction, such as deposit or withdraw
	 * @param transaction
	 * 				The amount being handled during transaction
	 */
	
	private void notifyFed(MoneyHolder<MonetaryUnit> source, String transactionType, PhysicalMonetaryUnit... transaction){
		LOG.info("running notifyFed with transaction type: " + transactionType);
		long value = 0;
		for(PhysicalMonetaryUnit money: transaction) {
			value = value+money.getValueInCents();
		}
		LOG.info("value of the transaction: "+ source + "is :" + value);
		if(value >= 10000000) {
			LOG.info("value of: " + value + " is greater than 10,000$ so notifying the Federal Goverment ");
			System.out.println("Notifying Fed regarding "+ source+" " + value+ " "+transactionType);
		}

	}
	/**
	 * Updates the observer 
	 * 
	 * @param source
	 * 			Where the money is coming from
	 * @param transactionType
	 * 			The type of transaction
	 * @param transaction
	 * 			The amount being handled during transaction
	 */
	@Override
	public void update(MoneyHolder<? extends MonetaryUnit> source, String transactionType,
			PhysicalMonetaryUnit... transaction) {
		LOG.info("running update for transaction:" + transactionType);
		// TODO Auto-generated method stub
		source.notify();
		
	}
	

	

}
