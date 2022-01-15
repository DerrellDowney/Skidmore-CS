package edu.skidmore.cs226.patterns.facade;

/**
 * Facade: Demonstrate how the Facade instance is used.
 * 
 * @author readda
 */
public class UseFacade {
    private void useWebPageAccess() {
        WebPageAccessFacade webPageAccess = new WebPageAccessFacade();
        HttpResponseFacade response =
            webPageAccess.getWebPage("http://monead.com");
        System.out.println(response.getPage());
    }

    public static void main(String[] args) {
        UseFacade facadeCheck = new UseFacade();
        facadeCheck.useWebPageAccess();
    }
}
