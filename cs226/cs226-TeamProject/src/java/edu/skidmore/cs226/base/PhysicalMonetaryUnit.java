package edu.skidmore.cs226.base;

import java.awt.Image;

import org.apache.log4j.Logger;

/**
 * Represents a physical MonetaryUnit (e.g. a coin or bill).
 * 
 * @author readda
 */
public abstract class PhysicalMonetaryUnit extends MonetaryUnit {
	
	
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PhysicalMonetaryUnit.class);
	}
    /**
     * The image for the front of the monetary unit.
     */
    private Image frontImage;

    /**
     * The image for the back of the monetary unit.
     */
    private Image backImage;

    /**
     * Create a PhysicalMonetaryUnit with its data defined.
     * 
     * @param name
     *            The name of the unit (e.g. penny, dollar bill...)
     * @param valueInCents
     *            The value of the monetary unit in cents
     * @param frontImage
     *            The image for the front of the monetary unit
     * @param backImage
     *            The image for the back of the monetary unit
     */
    public PhysicalMonetaryUnit(String name, long valueInCents,
        Image frontImage, Image backImage) {
        super(name, valueInCents);
        LOG.trace("creating a physicalMoneraryUnit with name" + name + " valueIncents:" + valueInCents + " frontImage:" + frontImage + " backImage:" + backImage );
        setFrontImage(frontImage);
        setBackImage(backImage);
    }

    /**
     * Get the image for the front of the monetary unit.
     * 
     * @return The image
     */
    public Image getFrontImage() {
    	LOG.info("calling getFrontImage");
    	LOG.debug("geting frontImage  " + frontImage);
        return frontImage;
    }

    /**
     * Set the image for the front of the monetary unit.
     * TODO Should this be read-only?
     * 
     * @param frontImage
     *            The image
     */
    public void setFrontImage(Image frontImage) {
    	LOG.info("calling setFrontImage");
    	LOG.debug("setting frontImage to: " + frontImage);
        this.frontImage = frontImage;
    }

    /**
     * Get the image for the back of the monetary unit.
     * 
     * @return The image
     */
    public Image getBackImage() {
    	LOG.info("calling getBackImage");
    	LOG.debug("geting backImgae: " + backImage);
        return backImage;
    }

    /**
     * Set the image for the back of the monetary unit.
     * TODO Should this be read-only?
     * 
     * @param backImage
     *            The image
     */
    public void setBackImage(Image backImage) {
    	LOG.info("calling setBackImage");
    	LOG.debug("setting backImage to: " + backImage);
        this.backImage = backImage;
    }

    @Override
    public boolean equals(Object obj) {
    	LOG.info("calling equals to find if object " + obj + " equals another object");
        // equivalence is based on name only (e.g. penny == "penny)
        if (obj instanceof PhysicalMonetaryUnit) {
        	LOG.info("the object was equals");
            PhysicalMonetaryUnit pmu = (PhysicalMonetaryUnit) obj;
            return pmu.getName().equals(this.getName());
        } else {
        	LOG.info("the object was not equals");
            return false;
        }
    }

    @Override
    public int hashCode() {
    	LOG.info("calling hashcode and returning the hashCode");
        return this.getName().hashCode();
    }
}
