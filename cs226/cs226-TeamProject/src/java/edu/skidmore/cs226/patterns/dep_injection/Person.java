package edu.skidmore.cs226.patterns.dep_injection;

import java.util.Date;

/**
 * Dependency Injection: Class to be injected
 * <p>
 * This class demonstrates dependency injection using both constructor and
 * setter-based approaches. A Person is a basic Javabean which is created
 * and then injected into a Mortgage object
 * </p>
 * 
 * @see Mortgage
 * @author readda
 */
public class Person {
    private String name;

    private Date dob;

    private double monthlyIncome;

    public Person() {

    }

    public Person(String name, Date dob, double monthlyIncome) {
        setName(name);
        setDob(dob);
        setMonthlyIncome(monthlyIncome);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String toString() {
        return "A person with the name " + getName() + ", DOB of " + getDob()
            + ", and monthly income of " + getMonthlyIncome();
    }
}
