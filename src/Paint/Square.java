package Paint;

import java.awt.*;

public class Square extends Rectangle {

    //// Constructors ////

    public Square() {
        super();
    }

    public Square(int px, int py, int length, int width, Color color) {
        super(px, py, Math.max(length, width), Math.max(length, width), color);
        this.length = Math.max(length, width);
        this.width = Math.max(length, width);
    }

    //// Setters ////

    public void setLength(int length) {
        this.length = length;
        this.width = length;
    }

    public void setWidth(int width) {
        this.width = width;
        this.length = width;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        this.length = Math.max(heightBB, widthBB);
        this.width = Math.max(heightBB, widthBB);
    }

    //// Override toString ////

    @Override
    public String toString() {
        return "Square created at"  +
                " point "           + origin.getX() + "x" + origin.getY() +
                ", length is "      + getLength() +
                ", width is "       + getWidth() +
                ", perimeter is "   + getPerimeter() +
                ", surface is "     + getSurface() +
                ", with color "     + getColor();

    }
}
