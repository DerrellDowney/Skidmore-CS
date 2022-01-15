package edu.skidmore.cs226.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor: Fabricated from book example (page 341).
 * <p>
 * Placeholder class for demonstrating the code in the Chassis class. This
 * represents a composite example (e.g. a computer chassis contains the parts of
 * the computer).
 * </p>
 * 
 * @author readda
 */
public class Chassis extends Equipment {
    private List<Equipment> parts;

    /**
     * This is not defined in the book's example. Here the code places 1 bus, 2
     * cards, and 1 floppy disk in the chassis.
     */
    public Chassis() {
        super("PC Chassis");
        parts = new ArrayList<>();
        parts.add(new Bus());
        parts.add(new Card());
        parts.add(new Card());
        parts.add(new FloppyDisk());
    }

    @Override
    public void accept(EquipmentVisitor ev) {
        for (Equipment equip : parts) {
            equip.accept(ev);
        }

        ev.visitChassis(this);
    }

    @Override
    public int power() {
        return 900;
    }

    @Override
    public double netPrice() {
        return 299.99;
    }

    @Override
    public double discountPrice() {
        return 250.0;
    }
}
