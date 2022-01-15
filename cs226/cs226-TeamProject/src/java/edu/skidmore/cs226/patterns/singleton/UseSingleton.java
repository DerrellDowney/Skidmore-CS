package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Demonstrate how the Singleton instance is accessed.
 * 
 * @author readda
 */
public class UseSingleton {
    private void useSingleton() {
        System.out.println("\nSingleton:");

        Singleton s1 = Singleton.getInstance();
        System.out.println("Got an instance of " + s1.getClass());

        Singleton s2 = Singleton.getInstance();
        System.out.println("Got an instance of " + s2.getClass());

        System.out.println(
            "Are the two variables referencing the same object? " + (s1 == s2));
    }

    private void useRegistrySingleton() {
        System.out.println("\nRegistrySingleton:");

        System.setProperty("SINGLETON", "MySingleton");
        MySingleton.init();

        RegistrySingleton s1 = RegistrySingleton.getInstance();
        System.out.println("Got an instance of " + s1.getClass());

        RegistrySingleton s2 = RegistrySingleton.getInstance();
        System.out.println("Got an instance of " + s2.getClass());

        System.out.println(
            "Are the two variables referencing the same object? " + (s1 == s2));
    }

    public static void main(String[] args) {
        UseSingleton singletonCheck = new UseSingleton();
        singletonCheck.useSingleton();
        singletonCheck.useRegistrySingleton();
    }
}
