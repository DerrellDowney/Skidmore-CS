package edu.skidmore.cs226.lab08;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;




public class CardDeck {
	
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(CardDeck.class);
	}
	
	
	
	private static List<Card> cardDeck = new ArrayList<>();
	/**
	 * declaring an instance of the card deck
	 */
	private static CardDeck instance;
	
	/**
	 * assinging the instance to a new cardDeck
	 */
	static {
		instance = new CardDeck();
	}
	
	/**
	 * Constructor for the card deck
	 */
	private CardDeck() {
		setUp();
		LOG.info("constructing card deck");
	}
	
	/**
	 * Getting the instance, if there is not one then one will be created
	 * @return the instance 
	 */
	public static CardDeck getInstance() {
		if(instance == null) {
			instance = new CardDeck();
		}
		return instance;
	}
	 /**
	  * Making a setup method to create a full deck of 52 cards
	  * to an array list
	  */
	public static void setUp() {
		LOG.info("adding enums");
		CardValue[] cv = CardValue.values();
		CardSuit[] cs = CardSuit.values();

		
           for (int i = 0; i < cs.length; i++) {
        	   for(int j = 0; j< cv.length; j++) {
        		   LOG.info("making a new card object");
        		   Card test = new Card();
        		   LOG.info("Assinging values to the card");
        		   test.setCardSuit(cs[i]);
        		   test.setCardValue(cv[j]);
        		   cardDeck.add(test);
            		}
           }
        
     }

	/**
	 * This method will pick a random card from the deck
	 * @return the randomly selected card
	 */
     public Card getRandomCard() {
    	 Random rand = new Random();
    	 Card pick;
    	 LOG.info("created random and a card");
    	 if(cardDeck.size() > 0) {
    		 LOG.info("picking a card");
    		 int index = rand.nextInt(cardDeck.size());
    		 pick = cardDeck.get(index);
    		 cardDeck.remove(index);
    		 
    	 }
    	 else {
    		 pick = null;
    	 }
    	 
    	 LOG.info("returning a card");
    	 return pick;
     }
     
     /**
      * Method is going to find the number of cards remaining
      * @return the size of the card deck
      */
     public int numCardsRemaining() {
    	 LOG.info("returning the size of the deck");
    	 int size = cardDeck.size();
    	 return size;
     }
    
	
}
