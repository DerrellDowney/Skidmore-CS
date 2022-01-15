package edu.skidmore.cs226.patterns.adapter;

/**
 * Adapter: Fabricated book example (page 147 and 148)
 * <p>
 * A Manipulator written to work with a TextShape object.
 * <p>
 * 
 * @author readda
 */
public class TextManipulator extends Manipulator {
    @SuppressWarnings("unused")
    private TextShape text;

    public TextManipulator(TextShape text) {
        this.text = text;
    }
}
