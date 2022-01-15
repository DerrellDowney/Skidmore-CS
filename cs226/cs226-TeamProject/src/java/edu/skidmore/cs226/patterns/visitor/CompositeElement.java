package edu.skidmore.cs226.patterns.visitor;

import java.util.List;

/**
 * Visitor: Translated book example (page 338).
 * <p>
 * Defines an Element subclass which contains a set of Element instances that
 * all visitors may visit.
 * </p>
 * 
 * @author readda
 */
public class CompositeElement extends Element {
    private List<Element> children;

    @Override
    public void accept(Visitor v) {
        for (Element child : children) {
            child.accept(v);
        }
    }

}
