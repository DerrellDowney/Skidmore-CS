package edu.skidmore.cs226.lab08;
import org.apache.log4j.Logger;



public class FiveCardDraw {
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(FiveCardDraw.class);
	}
	
	/**
	 * Prints out 5 randomly picked cards and the amount of cards left in the deck
	 * @param args 
	 */
	public static void main(String[] args) {
		LOG.info("creating a new card deck");
		CardDeck cardDeck = CardDeck.getInstance();
		
		for(int i = 0; i < 5; i++) {
			LOG.info("picking out a card");
			System.out.println(cardDeck.getRandomCard());
		}
		 LOG.info("printing out the number of cards remaining");
		System.out.println(cardDeck.numCardsRemaining());
	}
}
