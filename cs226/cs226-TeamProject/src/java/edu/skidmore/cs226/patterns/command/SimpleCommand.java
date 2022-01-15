package edu.skidmore.cs226.patterns.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Command: Translated book example (page 240)
 * <p>
 * General class for Commands that do not require additional arcuments.
 * </p>
 * 
 * @param <R>
 *            receiver containing the method to run when the command is invoked
 * @author readda
 */
public class SimpleCommand<R> extends Command {
    private Action action;

    private R receiver;

    public SimpleCommand(R r, Action a) {
        action = a;
        receiver = r;
    }

    /**
     * Method from top of page 241.
     */
    public void execute() {
        /*
         * Lookup the Action method in Receiver. This mimics what the use of a
         * function
         * pointer does in the book example
         */
        String methodName = action.toString();

        try {
            Method method = receiver.getClass().getMethod(methodName);
            method.invoke(receiver);
        }
        catch (NoSuchMethodException nsme) {
            System.err.println("The method " + methodName
                + " (no arguments) does not exist in " + receiver.getClass());
            nsme.printStackTrace();
        }
        catch (IllegalAccessException e) {
            System.err.println("The method " + methodName
                + " (no arguments) may not be called on "
                + receiver.getClass());
            e.printStackTrace();
        }
        catch (IllegalArgumentException | InvocationTargetException e) {
            System.err.println("The method " + methodName
                + " (no arguments) call failed on " + receiver.getClass());
            e.printStackTrace();
        }
    }
}
