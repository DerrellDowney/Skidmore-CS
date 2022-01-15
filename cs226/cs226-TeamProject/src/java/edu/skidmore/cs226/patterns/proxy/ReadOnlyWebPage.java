package edu.skidmore.cs226.patterns.proxy;

/**
 * Proxy: an interface for accessing the content of a web page
 * <p>
 * Created as a working example to demonstrate the proxy pattern in action.
 * </p>
 * 
 * @see WebPage
 * @see WebPageProxy
 * @author readda
 */
public interface ReadOnlyWebPage {
    String getAddress();
    
    String getPageText();

    boolean hasError();

    int numCharacters();
}
