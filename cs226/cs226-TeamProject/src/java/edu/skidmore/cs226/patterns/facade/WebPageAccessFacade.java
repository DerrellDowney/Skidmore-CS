package edu.skidmore.cs226.patterns.facade;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Facade: Access a URL and output the contents
 * <p>
 * Example of hiding the complexity of accessing a URL and retrieving the
 * content. This is not production worthy. It only handles GET requests, plain
 * text responses, and uncompressed or gzip compressed responses.
 * </p>
 * 
 * @author readda
 */
public class WebPageAccessFacade {
    public WebPageAccessFacade() {

    }

    /**
     * Fetch a web page. The method only properly supports GET requests and
     * responses that are text based (either uncompressed or gzip compressed).
     * If a redirect is returned the method will follow up to 5 redirects before
     * giving up and returning the last (5th) redirect response.
     * 
     * @param url
     *            The URL to retrieve
     * @return a response facade object or null if an error occurs
     */
    public HttpResponseFacade getWebPage(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponseFacade responseFacade = new HttpResponseFacade(url);
        try {
            int limitRedirects = 5;
            do {
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(responseFacade.getUrl()))
                    .header("user-agent", "dsr-java-program")
                    .build();
                System.out.println("Request: " + request);
                // responseFacade.setResponse(client.send(request,
                // HttpResponse.BodyHandlers.ofString()));
                responseFacade.setResponse(client.send(request,
                    HttpResponse.BodyHandlers.ofByteArray()));
                if (responseFacade.isRedirect()) {
                    --limitRedirects;
                    if (limitRedirects > 0) {
                        responseFacade.followRedirect();
                    }
                } else {
                    responseFacade.showHeaders();
                }
            } while (responseFacade.isRedirect() && limitRedirects > 0);
            return responseFacade;
        }
        catch (IOException | InterruptedException e) {
            System.out.println("Error fetching page: " + url);
            e.printStackTrace();
        }

        return null;
    }
}
