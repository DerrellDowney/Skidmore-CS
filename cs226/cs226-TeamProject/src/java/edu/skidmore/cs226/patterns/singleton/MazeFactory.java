package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Translated book example (page 132)
 * <p>
 * This uses a synchronized getInstance() method. You may hear about an
 * alternative approach using "double-check locking". It is to be avoided and is
 * considered an anti-pattern at this point.
 * </p>
 * <p>
 * The getInstance() method should not be written to accept parameters. If you
 * need to pass information to setup the Singleton then you need a Factory.
 * The Factory may return a Singleton for each set of parameter values
 * being supplied.
 * </p>
 * 
 * @author readda
 */
public class MazeFactory {
    /**
     * The singular instance of the class is stored in a class attribute.
     */
    private static MazeFactory instance;

    /**
     * The constructor is private. This prevents other classes from creating
     * instances of this class.
     */
    private MazeFactory() {

    }

    /**
     * The class method, getInstance(), provides the singular instance to the
     * caller. When using lazy initialization, the method must also handle
     * creating the instance when the first request is made for it.
     * 
     * @return The singular instance
     */
    public static synchronized MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }

        return instance;
    }
}
