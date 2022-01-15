package edu.skidmore.cs226.patterns.template;

/**
 * Template: Demonstrate how the Template instance is used.
 * 
 * @author readda
 */
public class UseTemplate {
    private void useMyView() {
        View view = new MyView();
        view.display();
    }

    public static void main(String[] args) {
        UseTemplate templateCheck = new UseTemplate();
        templateCheck.useMyView();
    }
}
