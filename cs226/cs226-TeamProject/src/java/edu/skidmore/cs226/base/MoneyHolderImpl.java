package edu.skidmore.cs226.base;
import org.apache.log4j.Logger;
import edu.skidmore.cs226.usepatterns.*;
/**
 * Provides the high-level default operations for a MoneyHolder of
 * PhysicalMonetaryUnits.
 * 
 * @author readda
 * logger Liam keith
 * @param <T>
 *            The class of PhysicalMonetaryUnits supported by this MoneyHolder
 */
public abstract class MoneyHolderImpl <T extends PhysicalMonetaryUnit> extends MonetaryTransactionSubject
    implements MoneyHolder<T>   {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MonetaryUnit.class);
	}
    /**
     * The description of this MoneyHolder.
     */
    private String description;

    /**
     * Create the MoneyHolder object with a description.
     * 
     * @param description
     *            The description
     */
    public MoneyHolderImpl(String description) {
    	LOG.info("Sets the description of the money holder");
        this.description = description;
    }
    /**
     * Returns the description
     * @return description The description
     */
    
    @Override
    public String getDescription() {
    	LOG.info("returns the description of the money holder");
        return description;
    }
    /**
     *The toString method
     *@return getDescription
     *			This is basically the description that was set and returned in the earlier methods 
     */
    @Override
    public String toString() {
    	LOG.info("Returns description as string");
        return getDescription();
    }
}
