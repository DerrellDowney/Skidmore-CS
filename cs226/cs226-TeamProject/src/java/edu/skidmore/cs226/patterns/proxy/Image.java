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
public class Image implements Graphic {
    public Image(String file) {

    }

    public void draw(Point at) {

    }

    public void handleMouse(Event event) {

    }

    public Point getExtent() {
        return null;
    }

    public void load(ObjectInputStream from) {

    }

    public void save(ObjectOutputStream to) {

    }
}
