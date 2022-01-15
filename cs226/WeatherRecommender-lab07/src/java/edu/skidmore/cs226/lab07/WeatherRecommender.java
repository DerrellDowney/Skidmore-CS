package edu.skidmore.cs226.lab07;

import org.apache.log4j.Logger;
import java.util.Scanner;

public class WeatherRecommender {
	private static final Logger LOG;


	static {
		LOG = Logger.getLogger(WeatherRecommender.class);
	}
	WeatherCondition[] wc= WeatherCondition.values();
	/**
	 * Method is going to show the weather options to the user
	 */
	private void showOptions() {
		LOG.info("printing out the options");
		for(int i = 0; i < wc.length; i++) {
			System.out.println(i+": " + wc[i]);
		}
	}
	
	/**
	 * The method is going to get the weather choice that the user picks
	 * and return the weather choice
	 * 
	 */
	private WeatherCondition getWeatherChoice(int choice) {
		LOG.info("returning the WeatherCondition");
		return wc[choice];
	}
		
	/**
	 * The method is going to give the user the recommendations for the chosen weather	
	 */
	
	private void reportRecs(WeatherCondition weatherCondition) {
		LOG.info("returning the information for the given choice");
		System.out.println("For condition: " + weatherCondition);
		System.out.println("Jacket: " + weatherCondition.getJacket());
		System.out.println("Shoes: " + weatherCondition.getShoes());
		System.out.println("Allow extra driving time: " + weatherCondition.isExtraTime());
	}
	
	public static void main(String[] args) {
		LOG.info("creating a new weatherrecommdner");
		WeatherRecommender wr = new WeatherRecommender();
		Scanner keyboard = new Scanner(System.in);
		
		LOG.info("showing the options");
		wr.showOptions();
		
		System.out.println("What option do you want to choose?: ");
		LOG.info("gathering user input");
		int choice = keyboard.nextInt();
		
		LOG.info("returning users recommendations");
		wr.reportRecs(wr.getWeatherChoice(choice));
	}
}