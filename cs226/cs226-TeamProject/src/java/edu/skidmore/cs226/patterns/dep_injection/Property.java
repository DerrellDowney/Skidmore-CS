package edu.skidmore.cs226.patterns.dep_injection;

/**
 * Dependency Injection: Class to be injected
 * <p>
 * This class demonstrates dependency injection using both constructor and
 * setter-based approaches. A Property is a basic Javabean which is created
 * and then injected into a Mortgage object
 * </p>
 * 
 * @see Mortgage
 * @author readda
 */
public class Property {
    private String address;

    private String structureType;

    private double appraisedValue;

    public Property(String address, String structureType,
        double appraisedValue) {
        setAddress(address);
        setStructureType(structureType);
        setAppraisedValue(appraisedValue);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public double getAppraisedValue() {
        return appraisedValue;
    }

    public void setAppraisedValue(double appraisedValue) {
        this.appraisedValue = appraisedValue;
    }

    public String toString() {
        return "A property of type " + getStructureType() + " located at "
            + getAddress() + " valued at " + getAppraisedValue();
    }
}
