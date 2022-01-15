package edu.skidmore.cs226.patterns.singleton;

/**
 * Singleton: Demonstrate how the Singleton instance is accessed.
 * 
 * @author readda
 */
public class UseMazeFactory {
    private void useMazeFactory() {
        System.out.println("\nMazeFactory:");

        MazeFactory mazeFactory = MazeFactory.getInstance();
        System.out.println("Got an instance of " + mazeFactory.getClass());

        MazeFactory mazeFactoryAgain = MazeFactory.getInstance();
        System.out.println("Got an instance of " + mazeFactoryAgain.getClass());

        if (mazeFactory == mazeFactoryAgain) {
            System.out.println("The MazeFactory instances are the same");
        } else {
            System.out
                .println("The MazeFactory instances are different (ouch!)");
        }
    }

    private void useAltMazeFactory() {
        System.out.println("\nAltMazeFactory:");

        AltMazeFactory altMazeFactory = AltMazeFactory.getInstance();
        System.out.println("Got an instance of " + altMazeFactory.getClass());

        AltMazeFactory altMazeFactoryAgain = AltMazeFactory.getInstance();
        System.out
            .println("Got an instance of " + altMazeFactoryAgain.getClass());

        if (altMazeFactory == altMazeFactoryAgain) {
            System.out.println(
                "The MazeFactoryAlternateExample instances are the same");
        } else {
            System.out.println(
                "The MazeFactoryAlternateExample instances are different"
                    + " (ouch!)");
        }

    }

    public static void main(String[] args) {
        UseMazeFactory useMazeFactory = new UseMazeFactory();
        useMazeFactory.useMazeFactory();
        useMazeFactory.useAltMazeFactory();
    }
}
