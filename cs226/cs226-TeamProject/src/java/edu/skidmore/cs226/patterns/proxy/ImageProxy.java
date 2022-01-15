package edu.skidmore.cs226.patterns.proxy;

import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Proxy: Translated book example (page 214-215)
 * <p>
 * This is a virtual proxy for the Image class.
 * </p>
 * 
 * @author readda
 */
public class ImageProxy implements Graphic {
    private Image image;

    private Point extent;

    private String fileName;

    public ImageProxy(String imageFile) {
        fileName = imageFile;
        extent = null;
        image = null;
    }

    Image getImage() {
        if (image == null) {
            image = new Image(fileName);
        }
        return image;
    }

    @Override
    public void draw(Point at) {
        getImage().draw(at);
    }

    @Override
    public void handleMouse(Event event) {
        getImage().handleMouse(event);
    }

    @Override
    public Point getExtent() {
        if (extent == null) {
            extent = getImage().getExtent();
        }

        return extent;
    }

    @Override
    public void load(ObjectInputStream from) {
        try {
            extent = (Point) from.readObject();
            fileName = (String) from.readObject();
        }
        catch (IOException | ClassNotFoundException ioe) {
            // in reality you'd log it!
            extent = null;
            fileName = null;
        }
    }

    @Override
    public void save(ObjectOutputStream to) {
        try {
            to.writeObject(extent);
            to.writeObject(fileName);
        }
        catch (IOException ioe) {
            // in reality you'd log it!
        }
    }

}
