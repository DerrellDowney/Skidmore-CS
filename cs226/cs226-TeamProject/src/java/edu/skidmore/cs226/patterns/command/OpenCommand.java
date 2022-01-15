package edu.skidmore.cs226.patterns.command;

import java.util.Scanner;

/**
 * Command: Translated book example (page 239)
 * <p>
 * Opens a document whose name is supplied from the user (externally). The
 * Command is passed to an Application object in its constructor. AskUser is the
 * implementation that prompts for the document to open.
 * </p>
 * 
 * @author readda
 */
public class OpenCommand extends Command {
    private Application application;

    @SuppressWarnings("unused")
    private String response;

    public OpenCommand(Application a) {
        application = a;
    }

    /**
     * Implementation from page 240.
     */
    public void execute() {
        String name = askUser();

        if (name != null) {
            Document document = new Document(name);
            application.add(document);
        }
    }

    /**
     * This method is not implemented in the book example. To keep it simple,
     * use a Scanner to get a filename from the user.
     * 
     * @return
     */
    protected String askUser() {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the document name to open:");
        return keyboard.nextLine();
    }
}
