package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 241)
 * <p>
 * Represents a concrete receiver of commands. Functionality is not dealt
 * with in the book example.
 * </p>
 * <p>
 * The book example for Receiver and Action rely upon function pointers which do
 * not exist in Java. See the discussion of the approach used here in rewriting
 * the example.
 * 
 * @see Action
 * @author readda
 */
public class MyClass {
    public void method1() {
        System.out.println("Method 1 executed");
    }

    public void method2() {
        System.out.println("Method 2 executed");
    }
}
