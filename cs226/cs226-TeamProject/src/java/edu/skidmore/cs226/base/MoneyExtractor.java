package edu.skidmore.cs226.base;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
/**
 * Used to extract a specific collection of PhysicalMonetaryUnits from a set of
 * PhysicalMonetaryUnits. This is currently a helper used in the various
 * MoneyHolder subclasses.
 * 
 * @author readda
 * @param <T>
 * logger Liam keith
 */
public class MoneyExtractor<T extends PhysicalMonetaryUnit> {
	private static final Logger LOG;
	static {
		LOG = Logger.getLogger(MonetaryUnit.class);
	}
    /**
     * Extract a set of objects from a collection (container) that match the
     * types of the supplied objects in a list (money). If the set of objects
     * cannot be found and exception is thrown.
     * TODO Check that this doesn't result in a ConcurrentModificationException
     * TODO Results in ClasscastException, leave for explanation of type erasure
     * 
     * @param container
     *            The collection of PhysicalMonetaryUnits from which objects are
     *            to be extracted
     * @param money
     *            The collection of PhysicalMonetaryUnits to extract
     * @return The set of extracted objects
     */
    @SuppressWarnings("unchecked")
    protected T[] extract(List<T> container, T... money) {
        List<T> extractedMoney = new ArrayList<>();

        for (T item : money) {
            int location = container.indexOf(item);
            if (location > -1) {
            	LOG.info("Extracts the object if found");
                extractedMoney.add((T) container.remove(location));
            } else {
            	LOG.info("puts extracted money back as object was not found");
                // Put any extracted money back
                container.addAll(extractedMoney);
                // for (T replaceitem : extractedMoney) {
                // container.add(replaceitem);
                // }
                throw new IllegalStateException(
                    "Cannot find a " + item + " in the " + container);
            }
        }
        LOG.warn("returns nothing if no object is found");
        return extractedMoney.toArray((T[]) new Object[extractedMoney.size()]);
    }

    /**
     * Extract a set of objects from a collection (container) that match the
     * types of the supplied objects in a list (money). If the set of objects
     * cannot be found and exception is thrown.
     * TODO Check that this doesn't result in a ConcurrentModificationException
     * 
     * @param container
     *            The collection of PhysicalMonetaryUnits from which objects are
     *            to be extracted
     * @param money
     *            The collection of PhysicalMonetaryUnits to extract
     * @return The set of extracted objects
     */
    public PhysicalMonetaryUnit[] extractPhysicalMonetaryUnit(
        List<PhysicalMonetaryUnit> container, PhysicalMonetaryUnit[] money) {
        List<PhysicalMonetaryUnit> extractedMoney = new ArrayList<>();
        for (PhysicalMonetaryUnit item : money) {
            int location = container.indexOf(item);
            if (location > -1) {
            	LOG.info("Takes out physical money if found");
                extractedMoney.add(container.remove(location));
            } else {
            	LOG.info("Puts any money back if not found");
                // Put any extracted money back
                container.addAll(extractedMoney);
                throw new IllegalStateException(
                    "Cannot find a " + item + " in the " + container);
            }
        }
        LOG.warn("returns nothing if no object is found");
        return extractedMoney
            .toArray(new PhysicalMonetaryUnit[extractedMoney.size()]);

    }

    /**
     * Extract a set of Coins from a collection (container) that match the
     * types of the supplied objects in a list (money). If the set of objects
     * cannot be found and exception is thrown.
     * TODO Check that this doesn't result in a ConcurrentModificationException
     * 
     * @param container
     *            The collection of Coins from which objects are
     *            to be extracted
     * @param money
     *            The collection of Coins to extract
     * @return The set of extracted objects
     */
    public Coin[] extractCoins(
        List<Coin> container, Coin[] money) {
        List<Coin> extractedMoney = new ArrayList<>();
        for (Coin item : money) {
            int location = container.indexOf(item);
            if (location > -1) {
            	LOG.info("Removes coin if found");
                extractedMoney.add(container.remove(location));
            } else {
            	LOG.info("Puts all removed coins back");
                // Put any extracted money back
                container.addAll(extractedMoney);
                throw new IllegalStateException(
                    "Cannot find a " + item + " in the " + container);
            }
        }
        LOG.warn("returns nothing if no object is found");
        return extractedMoney
            .toArray(new Coin[extractedMoney.size()]);

    }

    /**
     * Extract a set of PaperCurrency from a collection (container) that
     * match the types of the supplied objects in a list (money). If the set of
     * objects cannot be found and exception is thrown.
     * TODO Check that this doesn't result in a ConcurrentModificationException
     * 
     * @param container
     *            The collection of PaperCurrency from which objects are
     *            to be extracted
     * @param money
     *            The collection of PaperCurrency to extract
     * @return The set of extracted objects
     */
    public PaperCurrency[] extractPaperCurrency(
        List<PaperCurrency> container, PaperCurrency[] money) {
        List<PaperCurrency> extractedMoney = new ArrayList<>();
        for (PaperCurrency item : money) {
            int location = container.indexOf(item);
            if (location > -1) {
            	LOG.info("Removes desired paper currency if found");
                extractedMoney.add(container.remove(location));
            } else {
            	LOG.info("Returns all removed paper currency if not found");
                // Put any extracted money back
                container.addAll(extractedMoney);
                throw new IllegalStateException(
                    "Cannot find a " + item + " in the " + container);
            }
        }
        LOG.warn("returns nothing if no object is found");
        return extractedMoney
            .toArray(new PaperCurrency[extractedMoney.size()]);

    }
}
