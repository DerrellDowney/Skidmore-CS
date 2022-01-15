package edu.skidmore.cs226.patterns.facade;

import java.io.OutputStream;

/**
 * Facade: Translated and fabricated book example (page 190)
 * <p>
 * Generate machine code. Note that this class is based on the Visitor (331)
 * design pattern. Functionality is not dealt with in the book example.
 * </p>
 * 
 * @author readda
 */
public class CodeGenerator {
    @SuppressWarnings("unused")
    private OutputStream output;

    protected CodeGenerator(OutputStream bstream) {
        output = bstream;
    }

    public void visit(StatementNode node) {
    }

    public void visit(ExpressionNode node) {

    }
}
