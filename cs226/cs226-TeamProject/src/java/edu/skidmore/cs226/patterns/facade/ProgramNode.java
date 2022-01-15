package edu.skidmore.cs226.patterns.facade;

import java.util.List;

/**
 * Facade: Translated and fabricated book example (page 190)
 * <p>
 * Interface for manipulating the program node and any children. Note that this
 * class is based on the Composite (163) design pattern. Functionality is not
 * dealt with in the book example.
 * </p>
 * 
 * @author readda
 */
public class ProgramNode {
    // This is not in the book example but needed by traverse() example code on
    // page 191.
    private List<ProgramNode> children;

    protected ProgramNode() {

    }

    // Program node manipulation.
    /**
     * The book example uses references for the parameters so that they can be
     * updated. That is not possible in Java so the method has been changed to
     * return an array of ints. The first element would be the line number and
     * the second would be the index (position in the line).
     */
    public int[] getSourcePosition() {
        return new int[] { 0, 0 };
    }

    // child manipulation
    public void add(ProgramNode node) {

    }

    public void remove(ProgramNode node) {

    }

    public void traverse(CodeGenerator generator) {

    }

    /**
     * This is not in the book example but needed by traverse() example code on
     * page 191.
     * 
     * @return child nodes
     */
    protected List<ProgramNode> getChildren() {
        return children;
    }
}
