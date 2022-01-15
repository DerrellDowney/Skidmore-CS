package edu.skidmore.cs226.patterns.visitor;

/**
 * Visitor: Translated book example (page 340).
 * <p>
 * This serves as the superclass of things that can be visited
 * </p>
 * 
 * @author readda
 */
public abstract class Equipment {
  private String name;

  protected Equipment(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract void accept(EquipmentVisitor ev);

  public abstract int power();

  public abstract double netPrice();

  public abstract double discountPrice();
}
