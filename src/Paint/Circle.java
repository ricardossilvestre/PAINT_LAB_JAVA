package Paint;

import java.awt.*;

public class Circle extends Ellipse {

    //// Constructors ////

    public Circle() {
        super();
    }

    public Circle(int px, int py, int AxysX, int AxysY, Color color) {
        super(px, py, Math.max(AxysX, AxysY), Math.max(AxysX, AxysY), color);
        this.AxysX = Math.max(AxysX, AxysY);
        this.AxysY = Math.max(AxysX, AxysY);
    }

    //// Setters ////

    public void setSemiAxysX(int semiAxysX) {
        this.SemiAxysX = semiAxysX;
    }

    public void setSemiAxysY(int semiAxysY) {
        this.SemiAxysY = semiAxysY;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.AxysX = Math.max(heightBB, widthBB);
        this.AxysY = Math.max(heightBB, widthBB);
        this.SemiAxysX = Math.max(heightBB, widthBB) / 2;
        this.SemiAxysY = Math.max(heightBB, widthBB) / 2;
    }

    //// Override toString ////

    @Override
    public String toString() {
        return "Paint.Circle created at"  +
                " point "           + origin.getX() + "x" + origin.getY() +
                ", length is "      + getAxysX() +
                ", width is "       + getAxysY() +
                ", perimeter is "   + getPerimeter() +
                ", surface is "     + getSurface() +
                ", with color "     + getColor();

    }
}
