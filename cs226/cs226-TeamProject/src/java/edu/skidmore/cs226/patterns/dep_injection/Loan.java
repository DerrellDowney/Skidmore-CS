package edu.skidmore.cs226.patterns.dep_injection;

/**
 * Dependency Injection: Class to be injected
 * <p>
 * This class demonstrates dependency injection using both constructor and
 * setter-based approaches. A Loan is a basic Javabean which is created
 * and then injected into a Mortgage object
 * </p>
 * 
 * @see Mortgage
 * @author readda
 */
public class Loan {
    private int numPayments;

    private double principal;

    private double interestRate;

    public Loan(int numPayments, double principal, double interestRate) {
        setNumPayments(numPayments);
        setPrincipal(principal);
        setInterestRate(interestRate);
    }

    public int getNumPayments() {
        return numPayments;
    }

    public void setNumPayments(int numPayments) {
        this.numPayments = numPayments;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String toString() {
        return "A loan with principle " + getPrincipal() + ", interest rate "
            + getInterestRate() + " and term of " + getNumPayments();
    }
}
