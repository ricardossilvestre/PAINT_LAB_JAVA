package Paint;

import java.awt.*;

public class Ellipse extends Figure {

    protected int AxysX;
    protected int AxysY;
    private double pi = 3.14159265359;
    protected int SemiAxysX;
    protected int SemiAxysY;

    //// Constructors ////

    public Ellipse() {
        super(Color.lightGray, new Point());
        this.AxysX = 0;
        this.AxysY = 0;
    }

    public Ellipse(int px, int py, int AxysX, int AxysY, Color color) {
        super(color, new Point(px, py));
        this.AxysX = AxysX;
        this.AxysY = AxysY;
    }

    //// Getters ////

    public int getAxysX() {
        return AxysX;
    }

    public int getAxysY() {
        return AxysY;
    }

    public double getPerimeter(){
        double a = SemiAxysX;
        double b = SemiAxysY;
        double h = Math.pow((a-b)/(a+b),2);
        return pi*(a+b)*(1+((3*h)/(10+Math.sqrt(4-3*h))));
    }

    public double getSurface(){
        return SemiAxysX * SemiAxysY * pi;
    }

    //// Setters ////


    public void setSemiAxysX(int semiAxysX) {
        SemiAxysX = semiAxysX;
    }

    public void setSemiAxysY(int semiAxysY) {
        SemiAxysY = semiAxysY;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB){
        this.AxysX = heightBB;
        this.AxysY = widthBB;
        this.SemiAxysX = heightBB/2;
        this.SemiAxysY = widthBB/2;
    }

    //// Paint.Drawing ////

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.origin.getX(), this.origin.getY(), this.AxysX, this.AxysY);
    }


    //// Override toString ////

    @Override
    public String toString() {
        return "Paint.Ellipse created at" +
                " point "           + origin.getX() + "x" + origin.getY() +
                ", length is "      + getAxysX() +
                ", width is "       + getAxysY() +
                ", perimeter is "   + getPerimeter() +
                ", surface is "     + getSurface() +
                ", with color "     + getColor();

    }
}
