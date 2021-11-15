package Paint;

import java.awt.*;

public class Rectangle extends Figure {

    protected int length;
    protected int width;

    //// Constructors ////

    public Rectangle() {
        super(Color.lightGray, new Point());
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(int px, int py) {
        super(Color.lightGray, new Point(px, py));
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(int px, int py, int length, int width, Color color) {
        super(color, new Point(px, py));
        this.length = length;
        this.width = width;
    }

    //// Getters ////

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getPerimeter(){return 2*(length + width);}

    public int getSurface(){return length * width;}

    //// Setters ////

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {this.width = width;}

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        this.length = heightBB;
        this.width = widthBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.origin.getX(), this.origin.getY(), this.length, this.width);
    }

    //// Override toString ////

    @Override
    public String toString() {
        return "Rectangle created at"   +
                " point "               + origin.getX() + "x" + origin.getY() +
                ", length is "          + getLength() +
                ", width is "           + getWidth() +
                ", perimeter is "       + getPerimeter() +
                ", surface is "         + getSurface() +
                ", with color "         + getColor();

    }
}
