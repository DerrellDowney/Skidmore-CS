package edu.skidmore.cs226.patterns.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * Factory: Translated book example (page 113, Impl. 4)
 * <p>
 * A Factory which uses lazy initialization to create and return a single
 * instance of the Product (object). Note that this is a variant of Singleton
 * being used as a Factory.
 * </p>
 * 
 * @author readda
 */
public class StandardCreator {
    public Product createProduct(Class<? extends Product> theProduct) {
        try {
            return theProduct.getDeclaredConstructor().newInstance();
        }
        catch (NoSuchMethodException | InvocationTargetException
            | IllegalAccessException | InstantiationException e) {
            throw new IllegalArgumentException(
                "Cannot create instance of " + theProduct, e);
        }
    }
}
