package edu.skidmore.cs226.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton: Translated book example (page 131, Impl. 2)
 * <p>
 * Uses a registry of Singleton instances, one of which will be the instance
 * used at runtime based on a key, perhaps taken from the environment.
 * </p>
 * <p>
 * This is a less common use of a Singleton and generally should be a Factory.
 * Consider this:
 * https://stackoverflow.com/questions/3560103/
 *      how-to-force-a-class-to-be-initialised
 * </p>
 * 
 * @author readda
 */
public class RegistrySingleton {
    private static Map<String, RegistrySingleton> registry;

    private static RegistrySingleton instance;

    static {
        registry = new HashMap<>();
    }

    public static void register(String name, RegistrySingleton singleton) {
        registry.put(name, singleton);
    }

    protected RegistrySingleton() {

    }

    protected static RegistrySingleton lookup(String name) {
        return registry.get(name);
    }

    public static synchronized RegistrySingleton getInstance() {
        if (instance == null) {
            String singletonName = System.getProperty("SINGLETON");
            instance = lookup(singletonName);
        }

        return instance;
    }
}
