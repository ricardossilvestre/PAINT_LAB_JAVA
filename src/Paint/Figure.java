package Paint;

import java.awt.*;

public abstract class Figure implements java.io.Serializable {

    protected Color color;
    protected Point origin;
    public final double pi = 3.14159265359;

    //// Constructors ////

    public Figure() {
        this.color = Color.lightGray;
        this.origin = new Point();
    }

    public Figure(Color color, Point origin) {
        this.color = color;
        this.origin = origin;
    }

    //// Getters ////

    public Color getColor() {return color;}

    //// Setters ////

    public void setOrigin(Point P){this.origin = P;}

    //// Public Abstract Methods ////

    public abstract void setBoundingBox(int heightBB, int widthBB);

    public abstract void draw(Graphics g);

    @Override
    public String toString() {
        return "Paint.Figure color is " + color;
    }
}


