package edu.skidmore.cs226.patterns.visitor;

import java.util.Arrays;

/**
 * Visitor: Demonstrate how the Visitor is used. Expands on the example code
 * on page 342 which only looks at using the InventoryVisitor.
 * 
 * @author readda
 */
public class UseVisitor {
    private void useVisitor() {
        System.out.println("\nVisitor:");

        Visitor v = new Visitor();
        Element eA = new ElementA();
        Element eB = new ElementB();

        v.visitElementA(eA);
        v.visitElementB(eB);
    }

    private void useInventoryVisitor() {
        System.out.println("\nInventoryVisitor:");

        Equipment component = new Chassis();
        InventoryVisitor visitor = new InventoryVisitor();

        component.accept(visitor);
        System.out.println("Inventory: " + component.getName() + " "
            + Arrays.toString(visitor.getInventory()));
    }

    private void usePricingVisitor() {
        System.out.println("\nPricingVisitor:");

        Equipment component = new Chassis();
        PricingVisitor visitor = new PricingVisitor();
        component.accept(visitor);
        System.out.println(
            "Price for " + component.getName() + " is $"
                + visitor.getTotalPrice());

        component = new FloppyDisk();
        visitor = new PricingVisitor();
        component.accept(visitor);
        System.out.println(
            "Price for " + component.getName() + " is $"
                + visitor.getTotalPrice());
    }

    public static void main(String[] args) {
        UseVisitor visitorCheck = new UseVisitor();
        visitorCheck.useVisitor();
        visitorCheck.useInventoryVisitor();
        visitorCheck.usePricingVisitor();
    }
}
