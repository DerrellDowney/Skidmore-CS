package edu.skidmore.cs226.lab03;

/**
 * Represents a player of a game. This houses the player's information
 * including name and current score.
 *
 * @author readda and ddowney
 *
 */
public class Player {
	/**
	 * The player's name
	 */
	private String playerName;
	
	/**
	 * The player's current score
	 */
	private int playerScore;

	/**
	 * Constructor - no operation
	 */
	public Player() {
		
	}

	/**
	 * Set the name of the player
	 *
	 * @param theName The player's name
	 */
	public void setPlayerName(String newName) {
		playerName = newName;
	}

	/**
	 * Get the name of the player
	 *
	 * @return The player's name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Set the current score for the player
	 *
	 * @param theScore The player's current score
	 */
	public void setPlayerScore(int newScore) {
		playerScore = newScore;
	}

	/**
	 * Get the player's current score
	 *
	 * @return The player's current score
	 */
	public int getPlayerScore() {
		return playerScore;
	}

}
