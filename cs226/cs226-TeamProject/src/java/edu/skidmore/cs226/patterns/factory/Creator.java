package edu.skidmore.cs226.patterns.factory;

/**
 * Factory: Translated book example (page 111, Impl. 2)
 * <p>
 * Creates a specific instance based on the supplied parameter to the factory's
 * create() method.
 * </p>
 * 
 * @author readda
 */
public class Creator {
  public Product create(ProductId id) {
    if (id == ProductId.MINE) {
      return new MyProduct();
    } 
    if (id == ProductId.YOURS) {
      return new YourProduct();
    }

    return null;
  }
}
