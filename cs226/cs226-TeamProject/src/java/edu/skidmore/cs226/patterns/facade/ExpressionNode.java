package edu.skidmore.cs226.patterns.facade;

/**
 * Facade: Translated and fabricated book example (page 191)
 * <p>
 * Note that this class is based on the Visitor (331)
 * design pattern.
 * </p>
 * 
 * @author readda
 */
public class ExpressionNode extends ProgramNode {
    @Override
    public void traverse(CodeGenerator cg) {
        cg.visit(this);

        for (ProgramNode child : getChildren()) {
            child.traverse(cg);
        }
    }
}
