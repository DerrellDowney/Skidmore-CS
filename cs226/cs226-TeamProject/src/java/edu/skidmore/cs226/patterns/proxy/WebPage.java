package edu.skidmore.cs226.patterns.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebPage implements ReadOnlyWebPage {
    private String address;

    private String pageContent;

    private boolean error;

    public WebPage(String urlToAccess) {
        address = urlToAccess;
        try {
            URL url = new URL(address);
            BufferedReader br =
                new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            pageContent = sb.toString();
            error = false;
        }
        catch (IOException ioe) {
            // Should log the error
            pageContent = ioe.getMessage();
            error = true;
        }
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPageText() {
        return pageContent;
    }

    @Override
    public int numCharacters() {
        if (hasError()) {
            return -1;
        } else {
            return pageContent.length();
        }
    }

    @Override
    public boolean hasError() {
        return error;
    }

}
