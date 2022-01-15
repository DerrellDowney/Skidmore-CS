package edu.skidmore.cs226.patterns.adapter;

import java.awt.Point;

/**
 * Adapter: Translated book example (pages 147)
 * <p>
 * This is the book's object adapter example (further down in 147). The class
 * adapter example (pages 146-top of 147) cannot be reproduced in Java since
 * Java does not support multiple inheritance.
 * </p>
 * 
 * @author readda
 */
public class TextShape extends Shape {
    private TextView text;

    public TextShape(TextView text) {
        this.text = text;
    }

    /**
     * Reminder, the book's C++ example uses references which Java does not
     * support. This code is a little strange since, mimicking the reference
     * passing process, this method is expecting two Point objects which will be
     * updated by the method. A more traditional Java design would involve
     * returning the values in some fashion.
     */
    @Override
    public void boundingBox(Point bottomLeft, Point topRight) {
        Coord bottom = new Coord();
        Coord left = new Coord();
        Coord width = new Coord();
        Coord height = new Coord();

        // Note the parameters in the book example are backwards
        // (left should be x, and bottom should be y)
        text.getOrigin(left, bottom);
        text.getExtent(width, height);

        bottomLeft.x = left.getCoord();
        bottomLeft.y = bottom.getCoord();
        topRight.x = left.getCoord() + width.getCoord();
        topRight.y = bottom.getCoord() + height.getCoord();
    }

    public boolean isEmpty() {
        return text.isEmpty();
    }

    public Manipulator createManipulator() {
        return new TextManipulator(this);
    }

}
