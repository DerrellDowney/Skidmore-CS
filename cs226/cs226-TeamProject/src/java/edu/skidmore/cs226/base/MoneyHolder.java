package edu.skidmore.cs226.base;
/**
 * Defines a general money holder contract.
 * 
 * @author readda
 * @param <T>
 *            The type of MonetaryUnit that may be stored in the holder
 */
public interface MoneyHolder<T extends MonetaryUnit> {
    /**
     * Deposit MonetaryUnits into the MoneyHolder.
     * 
     * @param income
     *            The MonetaryUnits being deposited
     */
    @SuppressWarnings("unchecked")
    void deposit(T... income);

    /**
     * Withdraw MonetaryUnits from the MoneyHolder.
     * 
     * @param expense
     *            The MonetaryUnits being withdrawn
     * @return The set of MonetaryUnits withdrawn
     */
    @SuppressWarnings("unchecked")
    MonetaryUnit[] withdraw(T... expense);

    /**
     * Get the contents of the MoneyHolder.
     * 
     * @return The MonetaryUnits in the MoneyHolder
     */
    T[] contents();

    /**
     * Get the description of this MoneyHolder. Implementers should allow
     * MoneyHolders to have a description of some form that allows each to be
     * uniquely identified.
     * 
     * @return The description
     */
    String getDescription();
}
