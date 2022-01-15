package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Fabricated from book example (page 340).
 * <p>
 * Placeholder class for demonstrating the code in the FloppyDisk class.
 * </p>
 * 
 * @author readda
 */
public class FloppyDisk extends Equipment {
  public FloppyDisk() {
    super("Floppy Disk");
  }

  @Override
  public void accept(EquipmentVisitor ev) {
    ev.visitFloppyDisk(this);
  }

  @Override
  public int power() {
    return 45;
  }

  @Override
  public double netPrice() {
    return 24.99;
  }

  @Override
  public double discountPrice() {
    return 18.5;
  }
}
