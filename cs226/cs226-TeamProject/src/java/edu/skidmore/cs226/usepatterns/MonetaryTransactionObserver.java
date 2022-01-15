package edu.skidmore.cs226.usepatterns;

import edu.skidmore.cs226.base.MonetaryUnit;
import edu.skidmore.cs226.base.MoneyHolder;
import edu.skidmore.cs226.base.PhysicalMonetaryUnit;

public interface MonetaryTransactionObserver {
	public void update(MoneyHolder<? extends MonetaryUnit> source, String transactionType, PhysicalMonetaryUnit... transaction);
	}

