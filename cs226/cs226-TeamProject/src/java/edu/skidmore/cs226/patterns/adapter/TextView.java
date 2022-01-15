package edu.skidmore.cs226.patterns.adapter;

import java.awt.Point;

/**
 * Adapter: Translated book example (page 146)
 * <p>
 * Defines its rectangle using an origin, height and width.
 * </p>
 * 
 * @author readda
 */
public class TextView {
    private Coord x;

    private Coord y;

    private Coord width;

    private Coord height;

    public TextView(Point origin, Coord width, Coord height) {
        x = new Coord(origin.x);
        y = new Coord(origin.y);
        this.width = width;
        this.height = height;
    }

    public void getOrigin(Coord x, Coord y) {
        x.setCoord(this.x.getCoord());
        y.setCoord(this.y.getCoord());
    }

    public void getExtent(Coord width, Coord height) {
        width.setCoord(this.width.getCoord());
        height.setCoord(this.height.getCoord());
    }

    public boolean isEmpty() {
        return false;
    }
}
