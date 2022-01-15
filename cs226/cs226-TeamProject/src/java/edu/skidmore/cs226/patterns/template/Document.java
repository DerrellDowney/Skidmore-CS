package edu.skidmore.cs226.patterns.template;

/**
 * Template: Taken from the class diagram on (page 325)
 * <p>
 * Represents the Document being managed by the openDocument method in the
 * Application class.
 * </p>
 * 
 * @author readda
 */
public abstract class Document {
    public void save() {

    }

    public void open() {

    }

    public void close() {

    }

    public abstract void doRead();
}
