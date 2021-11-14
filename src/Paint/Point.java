package Paint;

public class Point implements java.io.Serializable {

    private int X;
    private int Y;

    public Point() {
        X = 0;
        Y = 0;
    }

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "("+X+","+Y+")";
    }
}