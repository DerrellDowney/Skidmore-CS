package edu.skidmore.cs226.patterns.adapter;

import java.awt.Point;

/**
 * Adapter: Translated book example (page 146)
 * <p>
 * Defines its rectangle using a bounding box defined by opposite corners.
 * </p>
 * 
 * @author readda
 */
public class Shape {
    private Point bottomLeft;

    private Point topRight;

    public void boundingBox(Point bottomLeft, Point topRight) {
        bottomLeft.x = this.bottomLeft.x;
        bottomLeft.y = this.bottomLeft.y;
        topRight.x = this.topRight.x;
        topRight.y = this.topRight.y;
    }

    public Manipulator createManipulator() {
        return new Manipulator();
    }
}
