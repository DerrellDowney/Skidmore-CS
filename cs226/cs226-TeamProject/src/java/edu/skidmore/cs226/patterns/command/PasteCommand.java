package edu.skidmore.cs226.patterns.command;

/**
 * Command: Translated book example (page 240)
 * <p>
 * Represents pasting information into a Document.
 * </p>
 * 
 * @author readda
 */
public class PasteCommand extends Command {
    private Document document;

    public PasteCommand(Document doc) {
        document = doc;
    }
    
    public void execute() {
        document.paste();
    }
}
