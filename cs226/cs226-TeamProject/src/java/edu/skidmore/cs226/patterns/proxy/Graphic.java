package edu.skidmore.cs226.patterns.proxy;

import java.awt.Point;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Proxy: Translated book example (page 213)
 * <p>
 * An interface for working with a graphical object.
 * </p>
 * 
 * @author readda
 */
public interface Graphic {
    void draw(Point at);

    void handleMouse(Event event);

    Point getExtent();

    void load(ObjectInputStream from);

    void save(ObjectOutputStream to);
}
