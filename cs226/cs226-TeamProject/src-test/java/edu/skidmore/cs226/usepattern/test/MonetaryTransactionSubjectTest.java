package edu.skidmore.cs226.usepattern.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import edu.skidmore.cs226.usepatterns.MonetaryTransactionObserver;
import edu.skidmore.cs226.usepatterns.MonetaryTransactionSubject;

/**
 * test class that subclasses MonetaryTransactionSubject
 * @author liami
 *
 */

public class MonetaryTransactionSubjectTest extends MonetaryTransactionSubject{
	/**
	 * The logger instance - a class-level constant.
	 */
	private static final Logger LOG;
	/**
	 * Static block for the logger
	 */
	static {
		LOG = Logger.getLogger(CreateBankAccount5000W200Test.class);
	}
	
	/**
	 * Tests attach to see that an observer (o) is being added to the list of observers
	 */
	@Test
	public void attachTest() {
		List <MonetaryTransactionObserver> observers = new ArrayList<>();
		MonetaryTransactionObserver o;
		attach(o);
		assertNotNull(observers);
	}
	/**
	 * Tests detach to see that an observer (o) is being removed from the list of observers
	 */
	@Test
	public void detachTest(){
		List <MonetaryTransactionObserver> observers = new ArrayList<>();
		MonetaryTransactionObserver o;
		attach(o);
		detach(o);
		assertNull(observers);
		
	}

}
