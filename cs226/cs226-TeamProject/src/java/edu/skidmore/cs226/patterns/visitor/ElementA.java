package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Translated book example (page 338).
 * <p>
 * Defines an Element subclass that all visitors may visit.
 * </p>
 * 
 * @author readda
 */
public class ElementA extends Element {
    public ElementA() {

    }

    @Override
    public void accept(Visitor v) {
        v.visitElementA(this);
    }
}
