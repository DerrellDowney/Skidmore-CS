package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Translated book example (page 131, Impl. 2)
 * <p>
 * A Singleton which registers itself in the Singleton registry.
 * </p>
 * 
 * @author readda
 */
public class MySingleton extends RegistrySingleton {
    static {
        System.out.println("MySingleton statically loaded");
        new MySingleton();
    }

    /**
     * A hack to allow code to force the Singleton class to register itself.
     */
    public static void init() {

    }

    protected MySingleton() {
        RegistrySingleton.register("MySingleton", this);
    }
}
