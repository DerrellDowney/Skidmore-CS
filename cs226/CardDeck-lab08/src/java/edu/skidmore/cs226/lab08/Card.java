package edu.skidmore.cs226.lab08;

import org.apache.log4j.Logger;


public class Card {
	
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(Card.class);
	}
	
	private CardValue cardValue;
	private CardSuit cardSuit;
	
	/**
	 * @return the cardValue
	 */
	public CardValue getCardValue() {
		return cardValue;
	}

	/**
	 * @param cardValue the cardValue to set
	 */
	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}

	/**
	 * @return the cardSuit
	 */
	public CardSuit getCardSuit() {
		return cardSuit;
	}

	/**
	 * @param cardSuit the cardSuit to set
	 */
	public void setCardSuit(CardSuit cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	/**
	 * overriding the toString to print more readable data
	 */
	public String toString() {
		return "Card: " + cardValue + " of " + cardSuit;
	}
}
