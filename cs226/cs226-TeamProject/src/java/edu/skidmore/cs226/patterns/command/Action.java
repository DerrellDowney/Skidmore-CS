package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 240)
 * <p>
 * Maintains the reference to the action to be carried out. Functionality is not
 * dealt with in the book example.
 * </p>
 * <p>
 * In the book's discussion of Action the value supplied is a pointer to the
 * function implementing the action. Java does not support pointers nor function
 * references. This translation uses reflection to find the method to run.
 * Action stores the name of the method (rather than a function pointer) and
 * returns it as its toString() value. Receiver's action() method then looks up
 * and runs the method when the action method is called.
 * </p>
 * <p>
 * Note that Action could be removed and the SimpleCommand simply use a String
 * for the method name. Action was kept to align with the book example.
 * </p>
 * 
 * @see Receiver
 * @author readda
 */
public class Action {
    private String methodToRun;

    public Action(String methodName) {
        methodToRun = methodName;
    }

    public String toString() {
        return methodToRun;
    }
}
