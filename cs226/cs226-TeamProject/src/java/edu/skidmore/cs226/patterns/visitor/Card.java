package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Fabricated from book example (page 340).
 * <p>
 * Placeholder class for demonstrating the code in the Card class.
 * </p>
 * 
 * @author readda
 */
public class Card extends Equipment {
  public Card() {
    super("Expansion Card");
  }

  @Override
  public void accept(EquipmentVisitor ev) {
    ev.visitCard(this);
  }

  @Override
  public int power() {
    return 90;
  }

  @Override
  public double netPrice() {
    return 45.99;
  }

  @Override
  public double discountPrice() {
    return 34.75;
  }
}
