package edu.skidmore.cs226.patterns.facade;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * A response facade providing access the to response body as well as header
 * fields.
 * 
 * @author readda
 */
public class HttpResponseFacade {
    /**
     * The url associated with the body and headers. This will be the redirected
     * url if a redirect was followed.
     */
    private String url;

    /**
     * The response headers.
     */
    private HttpHeaders httpHeaders;

    /**
     * The response.
     */
    private HttpResponse<byte[]> response;

    /**
     * Create a response wrapper set to retrieve the given URL.
     * 
     * @param url
     *            The url to retrieve
     */
    public HttpResponseFacade(String url) {
        this.url = url;
    }

    /**
     * Get the URL associated with this response. It will be the redirected URL
     * if a redirect was followed.
     * 
     * @return The URL associated with the body and headers
     */
    public String getUrl() {
        return url;
    }

    /**
     * The map of header values. Remember that HTTP eaders may have more than
     * one value so this is a map of lists of strings.
     * 
     * @return The header key/value map
     */
    public Map<String, List<String>> getHttpHeaders() {
        if (httpHeaders == null && response != null) {
            httpHeaders = response.headers();
        }
        return httpHeaders.map();
    }

    /**
     * Get the underlying response object.
     * 
     * @return The response
     */
    public HttpResponse<byte[]> getResponse() {
        return response;
    }

    /**
     * Set the response object. This will reset the headers as well.
     * 
     * @see HttpResponseFacade#invalidate()
     * @param response
     *            The response object
     */
    public void setResponse(HttpResponse<byte[]> response) {
        invalidate();
        this.response = response;
    }

    /**
     * Get the body content (the web page).
     * 
     * @return The body content from the response
     */
    public String getPage() {
        String encoding = getFirstPropValue("content-encoding");
        if (encoding == null) {
            encoding = "text";
        }

        String responseBody;
        switch (encoding) {
            case "gzip":
                responseBody = uncompressGzip();
                break;
            default:
                responseBody = new String(response.body());
        }
        return responseBody;
    }

    /**
     * Check whether this response is a redirect.
     * 
     * @return True if the response is a redirect
     */
    public boolean isRedirect() {
        return response.statusCode() == 301 || response.statusCode() == 302;
    }

    /**
     * Follow the redirect by altering the URL to match the location in the
     * redirect header. If the response is not a redirect the method has no
     * effect.
     */
    public void followRedirect() {
        showHeaders();
        if (isRedirect()) {
            url = getHttpHeaders().get("location").get(0);
            System.out.println("Changed URL to " + url);
        }
    }

    /**
     * Show the header keys and values on the console.
     */
    public void showHeaders() {
        System.out.println("Resp Code: " + response.statusCode());
        System.out.println("Resp URI: " + response.uri());
        for (String key : getHttpHeaders().keySet()) {
            System.out.println("Prop: " + key);
            for (String value : getHttpHeaders().get(key)) {
                System.out.println("     " + value);
            }
        }
    }

    /**
     * Get the first matching header value for the provided key.
     * 
     * @param propName
     *            The header property key
     * @return The first associated value or null if there is no value for the
     *         key
     */
    public String getFirstPropValue(String propName) {
        String[] values = getHeaderPropValues(propName);

        if (values.length > 0) {
            return values[0];
        } else {
            return null;
        }
    }

    /**
     * Get the set of header values associated with the provided key.
     * 
     * @param propName
     *            The header property key
     * @return The set of values associated with the key or a o-length array if
     *         no values are associated with the key.
     */
    public String[] getHeaderPropValues(String propName) {
        List<String> values = getHttpHeaders().get(propName);

        if (values != null) {
            return values.toArray(new String[values.size()]);
        } else {
            return new String[0];
        }
    }

    /**
     * Reset the response and header attributes.
     */
    private void invalidate() {
        response = null;
        httpHeaders = null;
    }

    /**
     * Uncompress a GZIP compressed response body.
     * see:
     * http://wpcertification.blogspot.com/2010/06/
     * decoding-gziped-response-in-httpclient.html
     * 
     * @return The uncompressed content or null if an error occurs.
     */
    private String uncompressGzip() {
        System.out.println("This is gzipped content");
        StringWriter responseBody = new StringWriter();
        PrintWriter responseWriter = new PrintWriter(responseBody);
        try {
            GZIPInputStream zippedInputStream =
                new GZIPInputStream(new ByteArrayInputStream(response.body()));
            BufferedReader r =
                new BufferedReader(new InputStreamReader(zippedInputStream));
            String line = null;
            while ((line = r.readLine()) != null) {
                responseWriter.println(line);
            }
        }
        catch (IOException ioe) {
            System.err.println("Unable to uncompress (gzip) the body");
            ioe.printStackTrace();
        }
        return responseBody.toString();
    }
}
