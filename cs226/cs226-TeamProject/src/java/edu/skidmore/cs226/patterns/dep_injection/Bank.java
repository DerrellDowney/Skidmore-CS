package edu.skidmore.cs226.patterns.dep_injection;

/**
 * Dependency Injection: Class to be injected
 * <p>
 * This class demonstrates dependency injection using both constructor and
 * setter-based approaches. A Bank is a basic Javabean which is created
 * and then injected into a Mortgage object
 * </p>
 * 
 * @see Mortgage
 * @author readda
 */
public class Bank {
    private String companyName;

    private String mainOfficeAddress;

    private String phoneNum;

    public Bank() {

    }

    public Bank(String companyName, String mainOfficeAddress, String phoneNum) {
        setCompanyName(companyName);
        setMainOfficeAddress(mainOfficeAddress);
        setPhoneNum(phoneNum);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMainOfficeAddress() {
        return mainOfficeAddress;
    }

    public void setMainOfficeAddress(String mainOfficeAddress) {
        this.mainOfficeAddress = mainOfficeAddress;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return "A bank named " + getCompanyName() + " located at "
            + getMainOfficeAddress() + " and phone number " + getPhoneNum();
    }
}
