package edu.skidmore.cs226.lab08.test;

import static org.junit.Assert.*;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.log.Log;

import edu.skidmore.cs226.lab08.CardDeck;

public class CardDeckTest {

	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(CardDeck.class);
	}
	
	/**
	 * Testing the setUp method
	 */
	@Test
	public void testSetUp() {
		LOG.info("creating a card deck object");
		CardDeck cardDeck = CardDeck.getInstance();
		assertNotNull(cardDeck);
	}
	
	/**
	 * Testing getRandomCard method
	 */
	@Test
	public void testGetRandomCard() {
		LOG.info("creating card deck objects");
		CardDeck cardDeck = CardDeck.getInstance();
		CardDeck cardDeck1 = CardDeck.getInstance();
		LOG.debug("returning a random card from the deck");
		cardDeck.getRandomCard();
		assertEquals(51, cardDeck.numCardsRemaining());
		for(int i = 52; i == 0; i--) {
			cardDeck1.getRandomCard();
		}
		LOG.debug("Testing that the method returns null when deck is empty");
		assertNull(cardDeck1.getRandomCard());
	}
	 /**
	  * Testing numCardsRemaining method
	  */
	@Test
	public void testNumCardsRemaining() {
		LOG.info("Creating two card decks");
		CardDeck cardDeck = CardDeck.getInstance();
		CardDeck cardDeck1 = CardDeck.getInstance();
		LOG.info("picking and removing a random card");
		cardDeck.getRandomCard();
		LOG.info("Checking if the number of cards is correct when removing one");
		assertEquals(51, cardDeck.numCardsRemaining());
		
		
	}
}
