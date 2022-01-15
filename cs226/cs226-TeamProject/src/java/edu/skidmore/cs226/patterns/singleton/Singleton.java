package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Translated book example (page 129, Impl. 1)
 * <p>
 * Creates a specific instance based on the supplied parameter to the factory's
 * create() method.
 * </p>
 * 
 * @author readda
 */
public class Singleton {
  private static Singleton instance;

  private Singleton() {

  }

  public static synchronized Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }

    return instance;
  }
}
