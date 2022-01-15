package edu.skidmore.cs226.lab02;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {
	/**
	 * Players choice of rock paper scissors
	 */
	public String playerChoice;
	
	/**
	 * The computer's choice
	 */
	public String computerChoice;
	
	/**
	 * Get the player's choice and places it into the playerChoice attribute.
	 */
	public void getPlayerChoice() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Type rock, paper, scissors, lizard, or spock");
		playerChoice = keyboard.nextLine();
		playerChoice = playerChoice.toLowerCase();
	}
	
	/**
	 * Computer chooses rock, paper, scissors
	 */
	public void getComputerChoice() {
		int numComputerChoice;
		Random rand = new Random();
		numComputerChoice = rand.nextInt(5);
		
		switch (numComputerChoice) {
			case 0:
				computerChoice = "rock";
				break;
			case 1:
				computerChoice = "paper";
				break;
			case 2:
				computerChoice = "scissors";
				break;	
			case 3:
				computerChoice = "lizard";
				break;
			case 4:
				computerChoice = "spock";
				break;	
		}
		
//		if (numComputerChoice == 0) {
//			computerChoice = "Rock";
//		}
//		else if (numComputerChoice == 1) {
//			computerChoice = "Paper";
//		}
//		else {
//			computerChoice = "Scissors";
//		}
	}
	
	/**
	 * Going to compare the results and print the results
	 */
	public void getResult() {
		if(playerChoice.equals("scissors") && (computerChoice.equals("paper")||computerChoice.equals("lizard"))) {
			if(computerChoice.equals("paper")) {
				System.out.println("The players scissors cuts the computers paper");
			}
			else {
				System.out.println("The players scissors decapitates the computers lizard");
			}
		}
		else if(playerChoice.equals("rock") && (computerChoice.equals("scissors")||computerChoice.equals("lizard"))) {
			if(computerChoice.equals("scissors")) {
				System.out.println("The players rock crushes the computers scissors");
			}
			else {
				System.out.println("The players rock crushes the computers lizard");
			}
		}
		else if(playerChoice.equals("paper") && (computerChoice.equals("rock")||computerChoice.equals("spock"))) {
			if(computerChoice.equals("rock")) {
				System.out.println("The players paper covers the computers rock");
			}
			else {
				System.out.println("The players paper disproves the computers spock");
			}
		}
		else if(playerChoice.equals("lizard") && (computerChoice.equals("paper")||computerChoice.equals("spock"))) {
			if(computerChoice.equals("paper")) {
				System.out.println("the players lizard eats the computers paper");
			}
			else {
				System.out.println("the players lizard poisons the computers spock");
			}
		}
		else if(playerChoice.equals("spock") && (computerChoice.equals("rock")||computerChoice.equals("scissors"))) {
			if(computerChoice.equals("rock")) {
				System.out.println("the players spock vaporizes the computers rock");
			}
			else {
				System.out.println("the players spock smashes the computers scissors");
			}
		}
		
		else if(playerChoice.equals(computerChoice)){
			System.out.println("Player and computer both chose "+ playerChoice+ " it's a tie!");
		}
		
		else {
			switch (computerChoice) {
			case "rock":
				if(playerChoice.equals("scissors")) {
					System.out.println("The computers rock crushes the players scissors");
				}
				else {
					System.out.println("The computers rock crushes the players lizard");
				}
				break;
			case "paper":
				if(playerChoice.equals("rock")) {
					System.out.println("The computers paper covers the players rock");
				}
				else {
					System.out.println("The computers paper disproves the players spock");
				}
				break;
			case "scissors":
				if(playerChoice.equals("paper")) {
					System.out.println("The computers scissors cuts the players paper");
				}
				else {
					System.out.println("The computers scissors decapitates the players lizard");
				}
				break;
			case "lizard":
				if(playerChoice.equals("paper")) {
					System.out.println("the computers lizard eats the players paper");
				}
				else {
					System.out.println("the computers lizard poisons the players spock");
				}
				break;
			case "spock":
				if(playerChoice.equals("rock")) {
					System.out.println("the computers spock vaporizes the players rock");
				}
				else {
					System.out.println("the computers spock smashes the players scissors");
				}
				break;
			}
		}
	}
	
	public static void main(String [] args) {
		RockPaperScissorsGame testGame = new RockPaperScissorsGame();
		
		testGame.getPlayerChoice();
		testGame.getComputerChoice();
		
		System.out.println("Player choice is: " + testGame.playerChoice);
		System.out.println("Computer choice is: " + testGame.computerChoice);
		
		testGame.getResult();
	}
}
