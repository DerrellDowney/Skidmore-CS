package edu.skidmore.cs226.usepatterns;

import org.apache.log4j.Logger;

import edu.skidmore.cs226.base.CoinJar;


public class RenameableCoinJar extends CoinJar{
	
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(RenameableCoinJar.class);
	}
	
	/**
	 * the description for the RenameableCoinJar
	 */
	private String description;

	/**
	 * The constructor for RenameableCoinJar
	 * @param description 
	 */
	public RenameableCoinJar(String description) {
		super(description);
		LOG.info("running RenameableCoinJar with description " + description);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * sets the description to name
	 * @param name
	 */
	public void setDescription(String name) {
		LOG.info("running setDescription and setting it to: " + name);
		description = name;
	}
	
	/**
	 * Overrides the getDescription from CoinJar
	 * and returns the description
	 */
	@Override
	public String getDescription() {
		LOG.info("running getDescription and getting: " + description);
		return description;
	}

}
