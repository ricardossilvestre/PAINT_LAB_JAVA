package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Drawing extends JPanel implements MouseMotionListener,MouseListener {


    private String nameFigure;
    private Color c;
    private ArrayList<Figure> list = new ArrayList<Figure>();
    private int x_pressed;
    private int y_pressed;
    private int x_length;
    private int y_width;
    public static final Color LIGHT_YELLOW = new Color(255, 249, 219);
//    int count = 0;



    public Drawing() {
        super();
        this.nameFigure = "Paint.Rectangle";
        this.c          = LIGHT_YELLOW;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    //// Setters ////

    public void setColor(Color c) {
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {this.nameFigure = nameFigure;}

    public void reset(){
        this.list.clear();
        this.repaint();

    }
    
    //// Getters ////

    public ArrayList<Figure> getList() {return list;}

    //// Paint Component ////

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.setBackground(LIGHT_YELLOW);
        for (Figure f : list){
            f.draw(graphics);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x_pressed = e.getX();
        y_pressed = e.getY();

        System.out.println("Initial position of " + this.x_pressed + "x" + this.y_pressed + " with color = " + this.c);

        x_length = Math.abs(x_length);

        y_width = Math.abs(x_length);

        if (nameFigure.equals("Paint.Rectangle")){
            this.list.add(new Rectangle(x_pressed, y_pressed, x_length, y_width, this.c));
        }

        if (nameFigure.equals("Paint.Ellipse")){
            this.list.add(new Ellipse(x_pressed, y_pressed, x_length, y_width, this.c));
        }

        if (nameFigure.equals("Paint.Square")){
            this.list.add(new Square(x_pressed, y_pressed, x_length, y_width, this.c));
        }

        if (nameFigure.equals("Paint.Circle")){
            this.list.add(new Circle(x_pressed, y_pressed, x_length, y_width, this.c));
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (nameFigure.equals("Paint.Rectangle")){
            System.out.println(list.get(list.size()-1));
        }

        if (nameFigure.equals("Paint.Ellipse")){
            System.out.println(list.get(list.size()-1));
        }

        if (nameFigure.equals("Paint.Square")){
            System.out.println(list.get(list.size()-1));
        }

        if (nameFigure.equals("Paint.Circle")){
            System.out.println(list.get(list.size()-1));
        }

        System.out.println("There is(are) now " + (list.size()-1) + " object(s) in the list");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        count ++;
//        if (count == 4){
//
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x_dragged = e.getX();
        int y_dragged = e.getY();
        x_length = (x_dragged - x_pressed);
        y_width =  (y_dragged - y_pressed);

        if (x_length < 0){
            list.get(list.size()-1).setOrigin(new Point(x_dragged, y_pressed));
        }
        if (y_width < 0){
            list.get(list.size()-1).setOrigin(new Point(x_pressed, y_dragged));
        }
        if (y_width < 0 && x_length < 0){
            list.get(list.size()-1).setOrigin(new Point(x_dragged, y_dragged));
        }
        list.get(list.size()-1).setBoundingBox(Math.abs(x_length), Math.abs(y_width));
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void saveDrawing() {
        FileOutputStream file;
        ObjectOutputStream out;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                file = new FileOutputStream(selectedFile.getAbsolutePath());
                out = new ObjectOutputStream(file);
                out.writeObject(this.list);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void recallDrawing() {
        reset();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                FileInputStream file_in = new FileInputStream(selectedFile.getAbsolutePath());
                ObjectInputStream in = new ObjectInputStream(file_in);
                this.list = (ArrayList<Figure>) in.readObject();
                this.repaint();
                in.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

} //// FINAL ////