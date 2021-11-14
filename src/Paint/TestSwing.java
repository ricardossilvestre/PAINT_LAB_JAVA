package Paint;

public class TestSwing {

    public static void main(String[] args) {

        //// Paint.Point Creation test ////

//        Paint.Point pointZero = new Paint.Point();
//        System.out.println(pointZero.toString());
//
//        Paint.Point somePoint = new Paint.Point(10, 20);
//        System.out.println(somePoint.toString());

        //// Paint.Rectangle creation test ////

//        Paint.Rectangle rectangleTest = new Paint.Rectangle(11,12, 13, 14, Color.BLUE);
//        System.out.println(rectangleTest.toString());
//        rectangleTest.setLength(15);
//        rectangleTest.setWidth(16);

//        Paint.Rectangle Rect1 = new Paint.Rectangle(3,6, Color.LIGHT_GRAY);
//        System.out.println("X: " + Rect1.getX() + "||Y: " + Rect1.getY() + "||Color: " + Rect1.getC());

//        Paint.Ellipse Ellip1 = new Paint.Ellipse(7,4, Color.BLUE);
//        System.out.println("X: " + Ellip1.getX() + "||Y: " + Ellip1.getY() + "||Color: " + Ellip1.getC());
//        System.out.println(Rect1.getPerimeter());

        //// ////
//
//        //Change de Lenght et Width du rectangle et Paint.Ellipse
//        Rect1.setLength(8);
//        Rect1.setWidth(10);
//        System.out.println("Length: "+Rect1.getLength(Rect1));/
//        System.out.println("Width: "+Rect1.getWidth(Rect1));
//        System.out.println("Perimeter :" + Rect1.getPerimeter(Rect1)); //Verification du périmètre
//        System.out.println("Surface :" + Rect1.getSurface(Rect1));  //Verification de la surface du rectangle
//        //===============================//
//        //Vérification des valeurs de Paint.Ellipse
//        Ellip1.setSemiAxisX(10);
//        Ellip1.setSemiAxisY(2);
//        System.out.println("SemiAxesX: " + Ellip1.getSemiAxisX(Ellip1));
//        System.out.println("SemiAxesY: " + Ellip1.getSemiAxisY(Ellip1));
//        System.out.println("Perimeter : " + Ellip1.getPerimeter(Ellip1));
//        //===============================//
//        //Vérification des valeurs de Paint.Square
//        Paint.Square  square1 = new Paint.Square(10, Color.ORANGE);
//        System.out.println("L Paint.Square :" + square1.getX());
        //===============================//

        ///// Paint.Window creation test ////

        Window win = new Window("Paint | Deluxe ultimate carnage reloaded edition", 800, 600);
    }
}