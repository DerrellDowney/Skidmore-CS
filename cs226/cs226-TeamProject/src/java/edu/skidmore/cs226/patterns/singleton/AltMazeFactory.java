package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Translated book example (page 133)
 * <p>
 * Singletons are commonly used without any subclasses. As the book
 * mentions this if/else construct in the getInstance() method might be better
 * dealt with using Factory or AbstractFactory.
 * </p>
 * <p>
 * Also, the subclassing arrangement adds complexity to the constructor
 * declaration since it must be accessible to subclasses.
 * <strong>In the <em>classic</em> Singleton pattern the constructor is
 * private.</strong>
 * </p>
 * 
 * @author readda
 */
public class AltMazeFactory {
    private static AltMazeFactory instance;

    /**
     * Protected since it must be accessible to its subclass.
     */
    protected AltMazeFactory() {

    }

    /**
     * This demonstrates the choice of specific Singleton instance being
     * controlled by an environment variable's value.
     * 
     * @return The singular instance
     */
    public static synchronized AltMazeFactory getInstance() {
        if (instance == null) {
            String mazeStyle = System.getenv("MAZESTYLE");

            if ("bombed".equals(mazeStyle)) {
                instance = new BombedMazeFactory();
            } else if ("enchanted".equals(mazeStyle)) {
                instance = new EnchantedMazeFactory();
            } else {
                // default
                instance = new AltMazeFactory();
            }
        }

        return instance;
    }
}
