package edu.skidmore.cs226.lab03;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import us.daveread.edu.graphics.shape.impl.Image;
import us.daveread.edu.graphics.shape.impl.Text;
import us.daveread.edu.graphics.surface.DrawingSurface;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Implements the "Guess the Number" game. Pits a person against the computer in
 * a game where each must guess a randomly selected number in a known range.
 *
 * @author YOUR_NAME_HERE
 *
 */
public class GuessTheNumber extends DrawingSurface {
	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The maximum number of guesses a player is allowed before losing the round
	 */
	public double maxGuesses;

	/**
	 * The limit value on the number that a player may choose for the other to
	 * guess. The legal numbers are from 0 to the limit minus 1.
	 */
	private int maxNum;

	/**
	 * A random number generator for the computer to use when choosing numbers
	 */
	private Random numGen;

	/**
	 * The human player's information
	 */
	private Player human;

	/**
	 * The computer player's information
	 */
	private Player computer;

	/**
	 * The number of rounds of the game to play
	 */
	private int numRounds;

	/**
	 * Display for the current computer score
	 */
	private Text displayComputerScore;

	/**
	 * Display for the current human score
	 */
	private Text displayHumanScore;

	/**
	 * Display for the current round #
	 */
	private Text displayRound;

	/**
	 * Display for the current player's name
	 */
	private Text displayCurrentPlayerName;

	/**
	 * Display for the number of guesses remaining
	 */
	private Text displayGuessesRemaining;

	/**
	 * Display for the current guess value
	 */
	private Text displayCurrentGuess;

	/**
	 * Display for the current clue or outcome
	 */
	private Image displayClueOrResult;

	/**
	 * Setup the game instance including the human and computer instances as
	 * well as the random number generator and keyboard reader instances.
	 */
	public GuessTheNumber() {
		new MainFrame(this, "Guess the Number", 600, 300);
		// Create instances of Player for the human and computer
		human = new Player();
		computer = new Player();

		// Set the computer's name
		computer.setPlayerName("Ron");

		// Create the instance of the random number generator
		numGen = new Random();
		
		// Set limit value
		do {
			maxNum = Integer.parseInt(getUserInput("What would you like the maximum number to be?"));
		} while (maxNum<10);
		

		// Set max number of guesses
		maxGuesses = Math.round(Math.sqrt(maxNum));

	}

	/**
	 * Setup the UI with labels and places for names, scores, and clues
	 */
	public void setupUi() {
		add(new Text("Round #", new Point(0, 20), 20, Color.black));
		add(new Text(human.getPlayerName(), new Point(0, 40), 20, Color.black));
		add(new Text(computer.getPlayerName(), new Point(0, 60), 20, Color.black));

		displayRound = new Text("0", new Point(120, 20), 20, Color.red);
		add(displayRound);
		displayHumanScore = new Text("0", new Point(120, 40), 20, Color.red);
		add(displayHumanScore);
		displayComputerScore = new Text("0", new Point(120, 60), 20, Color.red);
		add(displayComputerScore);

		add(new Text("Current Player:", new Point(200, 20), 20, Color.black));
		displayCurrentPlayerName = new Text("No Game", new Point(350, 20), 20, Color.red);
		add(displayCurrentPlayerName);

		add(new Text("Guesses Remaining:", new Point(20, 100), 20, Color.black));
		displayGuessesRemaining = new Text("", new Point(230, 100), 20, Color.blue.darker());
		add(displayGuessesRemaining);

		add(new Text("Guess:", new Point(158, 130), 20, Color.black));
		displayCurrentGuess = new Text("", new Point(230, 130), 20, Color.blue.darker());
		add(displayCurrentGuess);

		displayClueOrResult = new Image("question-mark.png", new Point(280, 80), Color.white);
		add(displayClueOrResult);
	}

	/**
	 * Play the game. This method will collect the initial information from the
	 * player (name and number of rounds), call setupUi to draw the main UI and
	 * then call playGame() to start the game.
	 *
	 * At the end of the game it should display the "Game Over" image in the
	 * displayClueOrResult image field.
	 *
	 * @see #playGame()
	 */
	public void run() {
		// Declare variables to temporarily house the player's name and desired
		// number of rounds
		String tempName;
		

		// Get the player's name using getUserInput()
		tempName = getUserInput("Get User Name", "What is your name?");

		// Get the number of rounds to play using getUserInput()
		numRounds = Integer.parseInt(getUserInput("How Many Rounds", "How many rounds would you like to play?"));

		// Set the name on the human Player instance with setName()
		human.setPlayerName(tempName);

		// Set the attribute (instance variable) for rounds to play
		

		// Call setupUi() to draw the initial screen components
		setupUi();

		// Call playGame() to run the game rounds
		playGame();

		// Display the "game over" image
		displayClueOrResult.setImageFileName("game-over.png");
	}

	/**
	 * Manage one round of the human attempting to guess a computer-selected
	 * number.
	 */
	public void humanTurn() {
		// Need to keep track of the value being sought, the latest guessed
		// value, the number of guesses used, and whether the player correctly
		// guessed the value
		int guessNum = numGen.nextInt(maxNum);
		int lastGuess;
		int guessCount = 0;
		boolean found = false;

		// Display a pop-up message indicating it is the player's turn
		// showErrorMessage()
		showErrorMessage(human.getPlayerName() + "'s Turn", "It is your turn");

		// Display the human player's name as current player and set the clue
		// image to a question mark
		// displayCurrentPlayerNamerandGen
		// displayClueOrResult
		displayClueOrResult.setImageFileName("question-mark.png");

		// Loop until the player guesses the correct number or runs out of
		// guesses
		while (found == false && guessCount < maxGuesses) {
			// Display the number of guesses remaining
			// displayGuessesRemaining
			displayGuessesRemaining.setMessage((maxGuesses - guessCount) + "");

			// Ask the user for their next guess
			// getUserInput()
			lastGuess = Integer.parseInt(getUserInput("Next Guess", human.getPlayerName() + ", what is your next guess?"));

			// Display the guess on the UI
			// displayCurrentGuess
			displayCurrentGuess.setMessage(lastGuess + "");

			// Check if the guess is correct and handle accordingly
			// If correct, set the variable tracking a correct guess to true
			if (lastGuess == guessNum) {
				found = true;
			}
			// If guess is too low, display the up arrow
			// displayClueOrResult
			if (lastGuess < guessNum) {
				displayClueOrResult.setImageFileName("up-arrow.png");
			}

			// If guess is too high, display the down arrow
			// displayClueOrResult
			if (lastGuess > guessNum) {
				displayClueOrResult.setImageFileName("down-arrow.png");
			}

			// Increment the number of guesses taken
			guessCount++;
		}

		// If the player guessed the number correctly, increment their score and
		// display a happy face
		// displayClueOrResult
		if (found) {
			displayClueOrResult.setImageFileName("happy-face.png");
			human.setPlayerScore(human.getPlayerScore() + 1);
		}

		// If the player did not guess the correct number, increment the
		// computer's score, show the correct number, and display a sad face
		// displayClueOrResult
		else {
			displayClueOrResult.setImageFileName("sad-face.png");
			computer.setPlayerScore(computer.getPlayerScore() + 1);
		}
	}

	/**
	 * Manage one round of the computer attempting to guess a computer-selected
	 * number. This code will closely mirror the humanTurn() method
	 * without keyboard input - use random number generator for computer's
	 * guess
	 */
	public void computerTurn() {
		int guessNum;
		// Need to keep track of the value being sought, the latest guessed
		// value, the number of guesses used, and whether the player correctly
		// guessed the value
		do {
			guessNum = Integer.parseInt(getUserInput("What # would you like the computer to guess"));
		} while (guessNum > maxNum);
//		int guessNum = numGen.nextInt(maxNum);
		int lastGuess;
		int guessCount = 0;
		boolean found = false;

		// Display a pop-up message indicating it is the player's turn
		// showErrorMessage()
		showErrorMessage(computer.getPlayerName() + "'s Turn", "It's Ron's turn");

		// Display the human player's name as current player and set the clue
		// image to a question mark
		// displayCurrentPlayerNamerandGen
		// displayClueOrResult
		displayClueOrResult.setImageFileName("question-mark.png");

		// Loop until the player guesses the correct number or runs out of
		// guesses
		while (found == false && guessCount < maxGuesses) {
			// Display the number of guesses remaining
			// displayGuessesRemaining
			displayGuessesRemaining.setMessage((maxGuesses - guessCount) + "");

			// Ask the user for their next guess
			// getUserInput()
			lastGuess = numGen.nextInt(maxNum);

			// Display the guess on the UI
			// displayCurrentGuess
			displayCurrentGuess.setMessage(lastGuess + "");

			// Check if the guess is correct and handle accordingly
			// If correct, set the variable tracking a correct guess to true
			if (lastGuess == guessNum) {
				found = true;
			}
			// If guess is too low, display the up arrow
			// displayClueOrResult
			if (lastGuess < guessNum) {
				displayClueOrResult.setImageFileName("up-arrow.png");
				
			}

			// If guess is too high, display the down arrow
			// displayClueOrResult
			if (lastGuess > guessNum) {
				displayClueOrResult.setImageFileName("down-arrow.png");
				
			}

			// Increment the number of guesses taken
			guessCount++;
		}

		// If the player guessed the number correctly, increment their score and
		// display a happy face
		// displayClueOrResult
		if (found) {
			displayClueOrResult.setImageFileName("happy-face.png");
			computer.setPlayerScore(computer.getPlayerScore() + 1);
		}

		// If the player did not guess the correct number, increment the
		// computer's score, show the correct number, and display a sad face
		// displayClueOrResult
		else {
			displayClueOrResult.setImageFileName("sad-face.png");
			human.setPlayerScore(human.getPlayerScore() + 1);
		}		
	}

	/**
	 * Update the scores on the UI
	 */
	public void reportScores() {
		// displayHumanScore
		displayHumanScore.setMessage(human.getPlayerScore() + "");
		// displayComputerScore
		displayComputerScore.setMessage(computer.getPlayerScore() + "");

	}

	/**
	 * Play the game. This will run as many rounds as were requested.
	 *
	 * For each round the method will:
	 *
	 * 1: Update the round number (displayRound)
	 *
	 * 2: Have the human take a turn
	 *
	 * 3: Have the computer take a turn
	 *
	 * 4: Report the current scores
	 *
	 * When the game ends this method will report the winner (or tie).
	 *
	 * @see #humanTurn()
	 * @see #computerTurn()
	 * @see #reportScores()
	 */
	public void playGame() {
		// Loop for each round, update round number, call humanTurn(),
		// call computerTurn(), and call reportScores() for each
		// iteration.
		for(int round = 0; round < numRounds; ++round) {
			humanTurn();
			computerTurn();
			reportScores();
		}

		// Report the final standings - e.g. overall winner or tie
		// showErrorMessage()
		if (human.getPlayerScore() > computer.getPlayerScore()) {
			showErrorMessage(human.getPlayerName() + "Won!", "You won the game!");
		}
		else if (human.getPlayerScore() < computer.getPlayerScore()) {
			showErrorMessage(computer.getPlayerName() + "Won!", "The computer won the game!");
		}
		else {
			showErrorMessage("Tie game!", human.getPlayerName() + " and " + computer.getPlayerName() + " tied!");
		}
			
	}

	/**
	 * Start the program by creating an instance of the GuessTheNumber class and
	 * calling its run() method.
	 *
	 * @param args
	 *            Command line arguments - not used
	 *
	 * @see #run()
	 */
	public static void main(String[] args) {
		GuessTheNumber game = new GuessTheNumber();
		game.run();
	}
}
