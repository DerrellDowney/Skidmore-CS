package edu.skidmore.cs226.patterns.proxy;

public class WebPageProxy implements ReadOnlyWebPage {
    private String webPageUrl;

    private WebPage webPage;

    public WebPageProxy(String url) {
        webPageUrl = url;
        webPage = null;
    }

    private WebPage getWebPage() {
        if (webPage == null) {
            webPage = new WebPage(webPageUrl);
        }
        return webPage;
    }

    @Override
    public String getAddress() {
        return webPageUrl;
    }

    @Override
    public String getPageText() {
        return getWebPage().getPageText();
    }

    @Override
    public boolean hasError() {
        return getWebPage().hasError();
    }

    @Override
    public int numCharacters() {
        return getWebPage().numCharacters();
    }
}
