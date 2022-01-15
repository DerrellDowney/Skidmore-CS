package edu.skidmore.cs226.base;

import java.awt.Image;

import org.apache.log4j.Logger;

/**
 * The set of known PhysicalMonetaryUnit denominations.
 * 
 * @author readda
 */
public enum PredefinedMonetaryUnit {

    /**
     * A penny, 1 cent.
     */
    PENNY("Penny", 1, true, null, null),
    /**
     * A nickel, 5 cents.
     */
    NICKEL("Nickel", 5, true, null, null),
    /**
     * A dime, 10 cents.
     */
    DIME("Dime", 10, true, null, null),
    /**
     * A quarter, 25 cents.
     */
    QUARTER("Quarter", 25, true, null, null),
    /**
     * A half-dollar, 50 cents.
     */
    HALF_DOLLAR("Half-dollar", 50, true, null, null),
    /**
     * A dollar bill, 100 cents.
     */
    DOLLAR_BILL("Dollar bill", 100, false, null, null),
    /**
     * A five dollar bill, 500 cents.
     */
    FIVE_DOLLAR_BILL("Five-dollar bill", 500, false, null, null),
    /**
     * A ten dollar bill, 1000 cents.
     */
    TEN_DOLLAR_BILL("Ten-dollar bill", 1000, false, null, null);

	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PredefinedMonetaryUnit.class);
	}
	
    /**
     * The name of the currency.
     */
    private String name;

    /**
     * The value of the currency in cents.
     */
    private int valueInCents;

    /**
     * Whether this is a coin as opposed to a paper bill.
     * TODO avoids switch statement when minting new currency
     */
    private boolean isCoin;

    /**
     * The image for the front of the currency.
     */
    private Image frontImage;

    /**
     * The image for the back of the currency.
     */
    private Image backImage;

    /**
     * Construct the enum.
     * 
     * @param name
     *            The currency name
     * @param valueInCents
     *            The currency value in cents
     * @param isCoin
     *            Whether the currency is a coin
     * @param frontImage
     *            The front image for the currency
     * @param backImage
     *            The back image for the currency
     */
    PredefinedMonetaryUnit(String name, int valueInCents,
        boolean isCoin, Image frontImage, Image backImage) {
        this.name = name;
        this.valueInCents = valueInCents;
        this.isCoin = isCoin;
        this.frontImage = frontImage;
        this.backImage = backImage;
    }

    /**
     * Get the name of the currency.
     * 
     * @return The name
     */
    public String getName() {
    	LOG.info("calling getName");
    	LOG.debug("geting Name: " + name);
        return name;
    }

    /**
     * Get the value of the currency in cents.
     * 
     * @return The value in cents
     */
    public int getValueInCents() {
    	LOG.info("calling getName");
    	LOG.debug("returning valueInCents: " + valueInCents);
        return valueInCents;
    }

    /**
     * Determine whether the currency a coin.
     * 
     * @return True if the currency is a coin, false otherwise
     */
    public boolean isCoin() {
    	LOG.info("calling isCoin");
    	LOG.debug("returning boolean iscoin: " + isCoin);
        return isCoin;
    }

    /**
     * Get the image for the front of the currency.
     * 
     * @return The image
     */
    public Image getFrontImage() {
    	LOG.info("calling getFrontImage");
    	LOG.debug("returning frontImage: " + frontImage);
        return frontImage;
    }

    /**
     * Get the image for the back of the currency.
     * 
     * @return The image
     */
    public Image getBackImage() {
    	LOG.info("calling getBackImage");
    	LOG.debug("returning backImage: " + backImage);
        return backImage;
    }
}
