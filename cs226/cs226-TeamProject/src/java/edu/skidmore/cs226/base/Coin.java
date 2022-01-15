package edu.skidmore.cs226.base;

import java.awt.Image;
import org.apache.log4j.Logger;


/**
 * Virtual monetary unit - based on US currency.
 * 
 * Derrell logging this class
 * @author readda
 */
public class Coin extends PhysicalMonetaryUnit {
	private static final Logger LOG;

	static {
		LOG = Logger.getLogger(Coin.class);
	}
    /**
     * Whether the Coin is heads up in its orientation. The design assumes that
     * a coin is either heads or tails up.
     */
    private boolean headsUp;

    /**
     * Create a coin with a given value and images for its heads and tails
     * orientation.
     * 
     * @param name
     *            The name of the coin
     * @param valueInCents
     *            The value of the coin in cents
     * @param headsImage
     *            The image to used used when the coin is heads up
     * @param tailsImage
     *            The image to be used when the coin is heads down
     */
    public Coin(String name, long valueInCents, Image headsImage,
        Image tailsImage) {
        super(name, valueInCents, headsImage, tailsImage);
        LOG.info("constructing a coin");
        LOG.debug("Coin has the name of: " + name + " and value of: "+ valueInCents + " and must take a head and tails image");
    }

    /**
     * Get the heads-up image of the coin.
     * 
     * @return The image
     */
    public Image getHeadsImage() {
    	LOG.info("returns the head image of the coin");
        return getFrontImage();
    }

    /**
     * Get the tails-up image of the coin.
     * 
     * @return The image
     */
    public Image getTailsImage() {
    	LOG.info("returning the tails image of a coin");
        return getBackImage();
    }

    /**
     * Mimic the flipping of a coin.
     * TODO This needs to be updated to use a random number generator
     */
    public void flip() {
    	LOG.info("Flipping a coin");
        headsUp = !headsUp;
    }

    /**
     * Check whether the coin is heads up.
     * 
     * @return True if the coin is heads-up, false otherwise
     */
    public boolean isHeadsUp() {
    	LOG.info("Checking is the coin is heads up");
        return headsUp;
    }

    /**
     * Get the correct image for the coin's current orientation (heads or tails
     * up).
     * 
     * @return The image
     */
    public Image upSideImage() {
    	LOG.info("returning the side of the coin facing up");
        return isHeadsUp() ? getHeadsImage() : getTailsImage();
    }

    @Override
    public String toString() {
    	LOG.info("returning the name as a toString method");
        return getName();
    }
}
