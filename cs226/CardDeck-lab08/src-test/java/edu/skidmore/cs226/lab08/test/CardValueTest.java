package edu.skidmore.cs226.lab08.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.mortbay.log.Log;

import edu.skidmore.cs226.lab08.CardDeck;
import edu.skidmore.cs226.lab08.CardValue;

import org.junit.Before;

public class CardValueTest {
	
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(CardValueTest.class);
	}
	
	/**
	 * Testing is the enum has the proper length
	 */
	@Test
	public void testLength() {
		LOG.info("");
		CardValue[] cv = CardValue.values();
		assertEquals(12, cv.length);
	}
	
	
	/**
	 * Testing if the enum is not null
	 */
	@Test
	public void testNotNull() {
		LOG.info("checking if the card value enums are not null");
		CardValue[] cv = CardValue.values();
		assertNotNull(cv);
	}
}
