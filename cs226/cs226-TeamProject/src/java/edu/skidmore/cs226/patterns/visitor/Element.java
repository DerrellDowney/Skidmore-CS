package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Translated book example (page 337).
 * <p>
 * Defines the Element class that all elements that may be visited must extend.
 * </p>
 * 
 * @author readda
 */
public abstract class Element {
    protected Element() {

    }

    public abstract void accept(Visitor v);
}
