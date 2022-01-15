package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 241)
 * <p>
 * Represents a client application using the SimpleCommand class to execute a
 * method indirectly through the command interface. Functionality is not dealt
 * with in the book example.
 * </p>
 * 
 * @author readda
 */
public class ClientApp {
    public void useCommandToExecuteMethod1OnMyClass() {
        MyClass receiver = new MyClass();
        Command aCommand =
            new SimpleCommand<MyClass>(receiver, new Action("method1"));

        /*
         * This call would happen as a result of some event (like the user
         * clicking on a button or signal being received from a external source
         * It would not typically follow the line above.
         */
        aCommand.execute();
    }

    public void useCommandToExecuteMethod2OnMyClass() {
        MyClass receiver = new MyClass();
        Command aCommand =
            new SimpleCommand<MyClass>(receiver, new Action("method2"));

        /*
         * This call would happen as a result of some event (like the user
         * clicking on a button or signal being received from a external source
         * It would not typically follow the line above.
         */
        aCommand.execute();
    }
}
