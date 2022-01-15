package edu.skidmore.cs226.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor: Translated book example (page 342).
 * <p>
 * A concrete visitor example.
 * </p>
 * 
 * @author readda
 */
public class InventoryVisitor extends EquipmentVisitor {
    private List<Equipment> inventory;

    public InventoryVisitor() {
        inventory = new ArrayList<>();
    }

    public Equipment[] getInventory() {
        return inventory.toArray(new Equipment[inventory.size()]);
    }

    @Override
    public void visitFloppyDisk(FloppyDisk fd) {
        inventory.add(fd);
    }

    @Override
    public void visitCard(Card c) {
        inventory.add(c);
    }

    @Override
    public void visitChassis(Chassis c) {
        inventory.add(c);
    }

    @Override
    public void visitBus(Bus b) {
        inventory.add(b);
    }
}
