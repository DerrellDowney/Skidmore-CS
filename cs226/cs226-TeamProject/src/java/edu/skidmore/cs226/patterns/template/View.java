package edu.skidmore.cs226.patterns.template;

/**
 * Template: Translated book example (page 329)
 * <p>
 * Defines the algorithm (template) for drawing on the screen.
 * </p>
 * 
 * @author readda
 */
public class View {
    public void display() {
        setFocus();
        doDisplay();
        resetFocus();
    }

    private void setFocus() {
        // code to setup the drawing state
        System.out.println("Default setFocus() in View");
    }

    /**
     * This is the "hook operation" that will handle the drawing. By default it
     * does nothing. Subclasses will override to add the desired functionality.
     * <p>
     * Arguably this could be abstract, making View abstract, since there is no
     * reason to use instances of this class without extending it. Another
     * advantage to making this abstract is it gives a clear signal that the
     * subclass must override it in order to be concrete.
     * </p>
     */
    protected void doDisplay() {
        System.out.println("Default doDisplay() in View");
    }

    private void resetFocus() {
        // code to release the drawing state
        System.out.println("Default resetFocus() in View");
    }
}
