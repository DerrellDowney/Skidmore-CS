package edu.skidmore.cs226.lab08.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;

import org.junit.Test;
import org.mortbay.log.Log;

import edu.skidmore.cs226.lab08.Card;
import edu.skidmore.cs226.lab08.CardDeck;
import edu.skidmore.cs226.lab08.CardSuit;
import edu.skidmore.cs226.lab08.CardValue;

public class CardTest {
	
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(CardTest.class);
	}
	
	/**
	 * Testing the get and set CardVale method
	 */
	@Test
	public void testGetSetCardValue() {
		Card card = new Card();
		CardValue[] cv = CardValue.values();
		LOG.info("Setting a suit to the card");
		card.setCardValue(cv[0]);;
		assertEquals("TWO", ""+ card.getCardValue());
	}
	
	
	/**
	 * Testing the set and get cardSuit method
	 */
	@Test
	public void testGetCardSuit() {
		Card card = new Card();
		CardSuit[] cs = CardSuit.values();
		LOG.info("Setting a value to the card");
		card.setCardSuit(cs[0]);
		assertEquals("HEARTS", ""+card.getCardSuit());
	}
	
	
}
