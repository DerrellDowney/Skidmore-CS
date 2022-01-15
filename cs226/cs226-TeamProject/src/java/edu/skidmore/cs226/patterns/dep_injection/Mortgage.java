package edu.skidmore.cs226.patterns.dep_injection;

/**
 * Dependency Injection: Class that has dependencies injected
 * <p>
 * Dependency injection (a form of Inversion of Control, IoC) is not
 * covered in our book. These classes and the associated Spring configurations
 * are used to show how dependency injection works both manually, through
 * coding, as well as through the use of the Spring IoC framework.
 * </p>
 * <p>
 * This class demonstrates dependency injection using both constructor and
 * setter-based approaches. A mortgage is defined as having a mortgagee, lien
 * holder, mortgaged property, and financial loan details. These are represented
 * as separate classes. The instances of those classes are injected into the
 * mortgage object to provide all the information. In other words, the Mortgage
 * class contains no code to create the objects for its attributes: Person,
 * Bank, etc.
 * </p>
 * 
 * @author readda
 */
public class Mortgage {
    private Person mortagee;

    private Bank lienholder;

    private Property property;

    private Loan loanDetails;

    public Mortgage() {

    }

    public Mortgage(Person mortagee, Property mortgagedProperty) {
        setMortgagee(mortagee);
        setProperty(mortgagedProperty);
    }

    public void setMortgagee(Person mortgagee) {
        this.mortagee = mortgagee;
    }

    public void setLienholder(Bank lienholder) {
        this.lienholder = lienholder;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setLoanDetails(Loan loanDetails) {
        this.loanDetails = loanDetails;
    }

    public String toString() {
        return "A mortgage made up of:\n   " + mortagee + "\n   " + lienholder
            + "\n   " + property + "\n   " + loanDetails;
    }
}
