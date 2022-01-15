package edu.skidmore.cs226.base;

import org.apache.log4j.Logger;


/**
 * A generic concept of a unit of money.
 * 
 * @author readda
 * logger Liam keith
 */
public abstract class MonetaryUnit {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MonetaryUnit.class);
	}
	
    /**
     * The name of the monetary unit (e.g. penny, nickel...)
     */
    private String name;
    
    /**
     * The value of the monetary unit in cents.
     */
    private long valueInCents;

    /**
     * Create an instance with its name and value defined.
     * 
     * @param name
     *            The name of the monetary unit
     * @param valueInCents
     *            The value of the monetary unit in cents
     */
    public MonetaryUnit(String name, long valueInCents) {
    	LOG.info("Sets the name of the Currency");
        setName(name);
        LOG.info("Sets the vaue of the currency in cents");
        setValueInCents(valueInCents);
    }

    /**
     * Get the name of the monetary unit.
     * 
     * @return The name
     */
    public String getName() {
    	LOG.info("Returns the currency name");
        return name;
    }

    /**
     * Set the name of the monetary unit.
     * TODO Should this be read-only?
     * 
     * @param name
     *            The name
     */
    public void setName(String name) {
    	LOG.info("Sets the currency name");
        this.name = name;
    }

    /**
     * Get the value of the monetary unit in cents.
     * 
     * @return The value
     */
    public long getValueInCents() {
    	LOG.info("returns the currency's value in cents");
        return valueInCents;
    }

    /**
     * Set the value of the monetary unit in cents.
     * TODO should this be read-only?
     * 
     * @param valueInCents
     *            The value
     */
    public void setValueInCents(long valueInCents) {
    	LOG.info("Sets the currency's value in cents");
        this.valueInCents = valueInCents;
    }
}
