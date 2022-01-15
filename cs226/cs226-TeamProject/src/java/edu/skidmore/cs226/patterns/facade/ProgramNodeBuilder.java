package edu.skidmore.cs226.patterns.facade;

/**
 * Facade: Translated and fabricated book example (page 189)
 * <p>
 * Build parse tree incrementally. Note that this class along with Scanner and
 * Parser interact based on the Builder (97) design pattern. Functionality is
 * not dealt with in the book example.
 * </p>
 * 
 * @author readda
 */
public class ProgramNodeBuilder {
    @SuppressWarnings("unused")
    private ProgramNode node;

    public ProgramNodeBuilder() {

    }

    public ProgramNode newVariable(String variableName) {
        return null;
    }

    public ProgramNode newAssignment(ProgramNode variable,
        ProgramNode expression) {
        return null;
    }

    public ProgramNode newReturnStatement(ProgramNode value) {
        return null;
    }

    public ProgramNode newCondition(ProgramNode condition, ProgramNode truePart,
        ProgramNode falsePart) {
        return null;
    }

    public ProgramNode getRootNode() {
        return null;
    }
}
