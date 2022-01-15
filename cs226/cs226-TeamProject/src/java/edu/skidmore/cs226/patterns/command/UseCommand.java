package edu.skidmore.cs226.patterns.command;

/**
 * Command: Demonstrate how the Command instances are used.
 * 
 * @author readda
 */
public class UseCommand {
    private void useClientApp() {
        System.out.println("\nCall method 1 via Command invocation");
        ClientApp app = new ClientApp();
        app.useCommandToExecuteMethod1OnMyClass();

        System.out.println("\nCall method 2 via Command invocation");
        app.useCommandToExecuteMethod2OnMyClass();

    }

    private void useMacroCommand() {
        System.out.println(
            "\nUse the macro command to execute copy and paste"
                + " commands running as a unit");
        Application app = new Application();
        Command open = new OpenCommand(app);

        // Get a document
        open.execute();

        MacroCommand mCmd = new MacroCommand();
        mCmd.add(new CopyCommand(app.getDocument()));
        mCmd.add(new PasteCommand(app.getDocument()));

        /*
         * This call would happen as a result of some event (like the user
         * clicking on a button or signal being received from a external source
         * It would not typically follow the line above.
         */
        mCmd.execute();
    }

    public static void main(String[] args) {
        UseCommand commandCheck = new UseCommand();
        commandCheck.useClientApp();
        commandCheck.useMacroCommand();
    }
}
