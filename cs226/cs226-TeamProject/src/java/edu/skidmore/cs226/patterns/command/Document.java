package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 240)
 * <p>
 * Represents a document to be edited. Functionality is not dealt
 * with in the book example.
 * </p>
 * 
 * @author readda
 */
public class Document {
    private String docName;

    public Document(String name) {
        docName = name;
        System.out.println("Document created for " + name);
    }

    /**
     * Fabricated method based on PasteCommand on page 240.
     */
    public void paste() {
        System.out.println("Pasted into " + docName);
    }

    /**
     * Fabricated method based on demonstrating MacroCommand (page 241).
     */
    public void copy() {
        System.out.println("Copied from " + docName);
    }

    public String toString() {
        return docName;
    }

}
