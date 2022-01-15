package edu.skidmore.cs226.base;

import java.awt.Image;

import org.apache.log4j.Logger;

/**
 * A PhysicalMonetaryUnit representing paper money (bills).
 * 
 * @author readda
 */
public class PaperCurrency extends PhysicalMonetaryUnit {
	
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(PaperCurrency.class);
	}
	
    /**
     * The serial number on the bill.
     */
    private String serialNumber;

    /**
     * Create a PaperCurrency object with its data defined.
     * 
     * @param name
     *            The name of the bill (e.g. dollar bill, five dollar bill...
     * @param valueInCents
     *            The value of the bill in cents
     * @param frontImage
     *            The image to be used for the front of the bill
     * @param backImage
     *            The image to be used for the back of the bill
     * @param serialNumber
     *            The serial number on the bill. The expectation is that this
     *            value will be unique to each bill. Currently the code does not
     *            enforce or rely on that fact.
     */
    public PaperCurrency(String name, long valueInCents, Image frontImage,
        Image backImage, String serialNumber) {
        super(name, valueInCents, frontImage, backImage);
        LOG.info("calling PaperCurrency");
        LOG.trace("creating a PaperCurrancy Name:" + name + " valueInCents:" + frontImage + " backImage: " + backImage + " serialNumber:" + serialNumber);
        LOG.debug("calling setting SerialNumber to: " + serialNumber);
        setSerialNumber(serialNumber);
    }

    /**
     * Get the serial number on the bill.
     * 
     * @return The serial number
     */
    public String getSerialNumber() {
    	LOG.info("calling getSerialNumber");
    	LOG.debug("geting serial number  " + serialNumber);
        return serialNumber;
    }

    /**
     * Set the serial number on the bill.
     * TODO Should this be read-only?
     * 
     * @param serialNumber
     *            The serial number
     */
    public void setSerialNumber(String serialNumber) {
    	LOG.info("calling setSerialNumber");
    	LOG.debug("seting the serial number to  " + serialNumber);
        this.serialNumber = serialNumber;
    }

    /**
     * to String method returns getName()
     */
    @Override
    public String toString() {
    	LOG.info("calling toString and returning " + getName());
        return getName();
    }
}
