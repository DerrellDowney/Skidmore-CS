package edu.skidmore.cs226.patterns.adapter;

/**
 * Adapter: Fabricated book example (page 146)
 * <p>
 * Maintains a coordinate value. Functionality is not
 * dealt with in the book example.
 * </p>
 * <p>
 * In the book's use of Coord, the value is often passed as a reference. Java
 * does not support reference types so this translation uses get/set methods to
 * allow for updates to the parameters in methods such as TextShape's
 * boundingBox()
 * </p>
 * 
 * @author readda
 */
public class Coord {
    private int coordinate;

    public Coord() {

    }

    public Coord(int coordinate) {
        setCoord(coordinate);
    }

    public int getCoord() {
        return coordinate;
    }

    public void setCoord(int coordinate) {
        this.coordinate = coordinate;
    }

    public String toString() {
        return "" + coordinate;
    }
}
