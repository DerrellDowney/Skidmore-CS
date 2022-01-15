package edu.skidmore.cs226.patterns.facade;

/**
 * Facade: Fabricated book example (page 190)
 * <p>
 * Note that this class is based on the Visitor (331)
 * design pattern.
 * </p>
 * 
 * @author readda
 */
public class StatementNode extends ProgramNode {
    @Override
    public void traverse(CodeGenerator cg) {
        cg.visit(this);

        for (ProgramNode child : getChildren()) {
            child.traverse(cg);
        }
    }
}
