package edu.skidmore.cs226.usepatterns;


public interface Observable {

	public void attach(MonetaryTransactionObserver o);
	public void detach(MonetaryTransactionObserver o);
	
	
}
