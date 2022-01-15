package edu.skidmore.cs226.lab03.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.skidmore.cs226.lab03.Player;

/**
 * Unit tests for the Player class.
 */
public class PlayerTest {
	/**
	 * A test player.
	 */
	private Player testPlayer;

	/**
	 * Setup the test player leaving default values intact.
	 */
	@Before
	public void setup() {
		testPlayer = new Player();
	}

	/**
	 * Test the default player name.
	 */
	@Test
	public void testDefaultPlayerName() {
		assertEquals("Incorrect default name for Player", null, testPlayer.getPlayerName());
	}

	/**
	 * Test the default player score.
	 */
	@Test
	public void testDefaultScore() {
		assertEquals("Incorrect default score for Player", 0, testPlayer.getPlayerScore());
	}

	/**
	 * Test a call to set the name.
	 */
	@Test
  public void testSetName() {
		testPlayer.setPlayerName("Ann");
		assertEquals("Incorrect name set for Player", "Ann", testPlayer.getPlayerName());
	}w

	/**
	 * Test a call the set the score.
	 */
	@Test
  public void testSetScore() {
		testPlayer.setPlayerScore(5);
		assertEquals("Incorrect score set for Player", 5, testPlayer.getPlayerScore());
	}
}
