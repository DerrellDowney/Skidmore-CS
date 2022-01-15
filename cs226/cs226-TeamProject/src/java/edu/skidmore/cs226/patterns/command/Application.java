package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 239)
 * <p>
 * Represents an application that is using commands. Functionality is not dealt
 * with in the book example.
 * </p>
 * 
 * @author readda
 */
public class Application {
    /**
     * Fabricated attribute based on OpenCommand and PasteCommand on pages
     * 239-240.
     */
    private Document document;

    /**
     * Fabricated method based on OpenCommand on page 240.
     * 
     * @param doc
     *            The document requested by the user
     */
    public void add(Document doc) {
        document = doc;
        System.out.println("Added " + getDocument() + " to application");
    }

    /**
     * Fabricated method based on OpenCommand and PasteCommand on pages
     * 239-240.
     */
    public Document getDocument() {
        return document;
    }
}
