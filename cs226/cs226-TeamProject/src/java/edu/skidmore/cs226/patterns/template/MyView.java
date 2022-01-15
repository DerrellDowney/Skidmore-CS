package edu.skidmore.cs226.patterns.template;

/**
 * Template: Translated from book example (page 329)
 * <p>
 * Specific view overriding the doDisplay() method from the template class
 * (View). Print statements were added so that calls the the methods are
 * displayed on the console when the UseTemplate class is run.
 * </p>
 * 
 * @author readda
 */
public class MyView extends View {
    /**
     * Override the inherited "hook operation" to do the necessary work.
     */
    protected void doDisplay() {
        // render the view's contents
        System.out.println("Overridden doDisplay() in MyView");
    }
}
