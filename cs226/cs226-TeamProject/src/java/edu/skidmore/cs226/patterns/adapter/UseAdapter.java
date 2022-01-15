package edu.skidmore.cs226.patterns.adapter;

import java.awt.Point;

/**
 * Adapter: Demonstrate how the Adapter instance is used.
 * 
 * @author readda
 */
public class UseAdapter {
    private void useTextShape() {
        // Create a text view with origin (10, 20), width 50, and height 40
        TextView text =
            new TextView(new Point(10, 20), new Coord(50), new Coord(40));

        TextShape textShape = new TextShape(text);

        // boundingBox adapts between the TextArea coordinate representation and
        // the Shape coordinate representation
        Point bottomLeft = new Point(0, 0);
        Point topRight = new Point(0, 0);
        textShape.boundingBox(bottomLeft, topRight);

        // Report the information from both coordinate representations.
        // The bounding boxes should agree.
        Coord x = new Coord();
        Coord y = new Coord();
        Coord width = new Coord();
        Coord height = new Coord();
        text.getOrigin(x, y);
        text.getExtent(width, height);
        System.out.println("The TextView bounding box is: origin:(" + x + ", "
            + y + ")" + ", width:" + width + " height:" + height);

        System.out.println("The textShape bounding box is: bottomLeft:"
            + bottomLeft + " topRight:" + topRight);

    }

    public static void main(String[] args) {
        UseAdapter adapterCheck = new UseAdapter();
        adapterCheck.useTextShape();
    }
}
