package edu.skidmore.cs226.lab08.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import edu.skidmore.cs226.lab08.CardDeck;
import edu.skidmore.cs226.lab08.CardSuit;

public class CardSuitTest {
	
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(CardSuitTest.class);
	}
	
	/**
	 * Testing is the enum has the proper length
	 */
	public void testLength() {
		LOG.info("checking if the amount of values is right");
		CardSuit[] cs = CardSuit.values();
		assertEquals(3, cs.length);
	}
	
	
	/**
	 * Testing if the enum is not null
	 */
	public void testNotNull() {
		LOG.info("checking if the enums of values is not null");
		CardSuit[] cs = CardSuit.values();
		assertNotNull(cs);
	}
}
