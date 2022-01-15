package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Translated book example (page 341).
 * <p>
 * A concrete visitor example.
 * </p>
 * 
 * @author readda
 */
public class PricingVisitor extends EquipmentVisitor {
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void visitFloppyDisk(FloppyDisk fd) {
        totalPrice += fd.netPrice();
    }

    @Override
    public void visitCard(Card c) {
        totalPrice += c.netPrice();
    }

    @Override
    public void visitChassis(Chassis c) {
        totalPrice += c.discountPrice();
    }

    @Override
    public void visitBus(Bus b) {
        totalPrice += b.netPrice();
    }
}
