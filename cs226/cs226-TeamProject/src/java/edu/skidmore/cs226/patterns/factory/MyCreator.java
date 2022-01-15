package edu.skidmore.cs226.patterns.factory;

/**
 * Factory: Translated book example (page 111, Impl. 2)
 * <p>
 * Subclass of the initial Factory class, Creator, which overrides the create()
 * method to change the set of returned object instances.
 * </p>
 * 
 * @author readda
 */
public class MyCreator extends Creator {
    public Product create(ProductId id) {
        if (id == ProductId.YOURS) {
            return new MyProduct();
        }
        if (id == ProductId.MINE) {
            return new YourProduct();
        }
        if (id == ProductId.THEIRS) {
            return new TheirProduct();
        }

        return super.create(id);

    }
}
