package edu.skidmore.cs226.patterns.template;

import java.util.List;

/**
 * Template: Translated book example (page 325)
 * <p>
 * Defines the algorithm (template) for opening and reading a document.
 * </p>
 * <p>
 * Includes methods based on the class diagram on page 325.
 * </p>
 * 
 * @author readda
 */
public abstract class Application {
    /**
     * This attribute is not shown in the book example but would be required
     * based on the openDocument() method's code.
     */
    private List<Document> docs;

    public void openDocument(String name) {
        if (!canOpenDocument(name)) {
            // cannot handle this document
            return;
        }

        Document doc = doCreateDocument();

        if (doc != null) {
            // This next statement is incorrectly using the docs attribute in
            // the book example
            addDocument(doc);
            aboutToOpenDocument(doc);
            doc.open();
            doc.doRead();
        }
    }

    /**
     * This is the likely operation intended by the code example.
     */
    protected void addDocument(Document doc) {
        docs.add(doc);
    }

    protected void openDocument() {

    }

    /*
     * The following abstract methods are the primitive operations described in
     * the book.
     */

    protected abstract Document doCreateDocument();

    protected abstract boolean canOpenDocument(String name);

    protected abstract void aboutToOpenDocument(Document doc);
}
