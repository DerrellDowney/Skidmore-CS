package edu.skidmore.cs226.patterns.proxy;

/**
 * Proxy: Translated book example (page 215)
 * <p>
 * This represents a class that uses a text document. In the book the code is
 * shown without a class or method declaration.
 * </p>
 * 
 * @author readda
 */
public class EditorOfTextDocument {
    public EditorOfTextDocument() {
        TextDocument text = new TextDocument();
        // ...
        text.insert(new ImageProxy("anImageFileName"));
    }
}
