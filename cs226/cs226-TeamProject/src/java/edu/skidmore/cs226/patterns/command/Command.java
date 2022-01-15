package edu.skidmore.cs226.patterns.command;

/**
 * Command: Translated book example (page 239)
 * <p>
 * This is the abstract Command class. All Commands will extend this class.
 * </p>
 * 
 * @author readda
 */
public abstract class Command {
    protected Command() {
        
    }
    
    public abstract void execute();
}
