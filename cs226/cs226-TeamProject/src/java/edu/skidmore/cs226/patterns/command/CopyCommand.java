package edu.skidmore.cs226.patterns.command;

/**
 * Command: Fabricated book example (page 240)
 * <p>
 * Represents copying information from a Document.
 * </p>
 * 
 * @author readda
 */
public class CopyCommand extends Command {
    private Document document;

    public CopyCommand(Document doc) {
        document = doc;
    }

    public void execute() {
        document.copy();
    }
}
