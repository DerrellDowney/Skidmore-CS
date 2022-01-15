package edu.skidmore.cs226.lab07;


public enum WeatherCondition {
	
	/**
	 * creating and setting parameters to enums
	 */
	COLD_CLEAR("Heavy", "Warm", false, "Cold and Clear"),  
	SNOW("Heavy", "Boots", true, "Snow"), 
	COOL_CLEAR("Light", "Sneakers", false, "Cool and Clear"),
	RAIN("Raincoat", "Galoshes", true, "Rain"),
	WARM_CLEAR("None", "Sandals", false, "Warm and Clear");
	
	/**
	 * attributes
	 */
	private String jacket;
	private String shoes;
	private boolean extraTime;
	private String desc;
	/**
	 * Constructor
	 * @param jacket
	 * @param shoes
	 * @param extraTime
	 */
	WeatherCondition(String jacket, String shoes, boolean extraTime, String desc){
		this.jacket = jacket;
		this.shoes = shoes;
		this.extraTime = extraTime;
		this.desc = desc;
		
	}
	/**
	 * @return the jacket
	 */
	public String getJacket() {
		return jacket;
	}
	/**
	 * @return the shoes
	 */
	public String getShoes() {
		return shoes;
	}
	/**
	 * @return the extraTime
	 */
	public boolean isExtraTime() {
		return extraTime;
	}
	/**
	 * overriding the toString method
	 */
	public String toString() {
		return desc;
	}
	
}
