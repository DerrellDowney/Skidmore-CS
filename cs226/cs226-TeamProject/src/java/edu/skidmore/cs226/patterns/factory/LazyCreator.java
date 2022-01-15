package edu.skidmore.cs226.patterns.factory;

/**
 * Factory: Translated book example (page 113, Impl. 3)
 * <p>
 * A Factory which uses lazy initialization to create and return a single
 * instance of the Product (object). Note that this is a variant of Singleton
 * being used as a Factory.
 * </p>
 * 
 * @author readda
 */
public class LazyCreator {
    private Product theProduct;

    /**
     * This method is not shown in the book example.
     * 
     * @return The created product instance
     */
    protected Product create() {
        return new MyProduct();
    }

    public synchronized Product getProduct() {
        if (theProduct == null) {
            theProduct = create();
        }

        return theProduct;
    }
}
