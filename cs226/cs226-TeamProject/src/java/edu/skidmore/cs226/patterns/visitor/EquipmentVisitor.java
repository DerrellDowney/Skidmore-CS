package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Translated book example (page 340).
 * <p>
 * This serves as the superclass of visitors
 * </p>
 * 
 * @author readda
 */
public abstract class EquipmentVisitor {
    protected EquipmentVisitor() {

    }

    public abstract void visitFloppyDisk(FloppyDisk fd);

    public abstract void visitCard(Card c);

    public abstract void visitChassis(Chassis c);

    public abstract void visitBus(Bus b);
}
