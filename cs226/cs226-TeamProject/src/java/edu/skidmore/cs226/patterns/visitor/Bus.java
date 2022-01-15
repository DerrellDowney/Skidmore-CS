package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Fabricated from book example (page 340).
 * <p>
 * Placeholder class for demonstrating the code in the Bus class.
 * </p>
 * 
 * @author readda
 */
public class Bus extends Equipment {
  public Bus() {
    super("PC 64-bit Bus");
  }

  @Override
  public void accept(EquipmentVisitor ev) {
    ev.visitBus(this);
  }

  @Override
  public int power() {
    return 120;
  }

  @Override
  public double netPrice() {
    return 179.99;
  }

  @Override
  public double discountPrice() {
    return 155.5;
  }

}
