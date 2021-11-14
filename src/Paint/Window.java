package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Window extends JFrame implements ActionListener {


    protected Drawing drawing;
    private Container contentPanel;

    public Window(String Title, int x, int y)
    {
        //// Pane Configuration ////

        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.contentPanel = this.getContentPane();


        //// Menu bar ////

            //>// Menu 1 ////

        JMenuBar m = new JMenuBar();

        JMenu menu1         = new JMenu("File");
        JMenuItem menu1New  = new JMenuItem("New");
        JMenuItem menu1Open = new JMenuItem("Open");
        JMenuItem menu1Save = new JMenuItem("Save");
        JMenuItem menu1Quit = new JMenuItem("Quit");

        menu1New.addActionListener(this);
        menu1Open.addActionListener(this);
        menu1Save.addActionListener(this);
        menu1Quit.addActionListener(this);

        menu1.add(menu1New);
        menu1.add(menu1Open);
        menu1.add(menu1Save);
        menu1.addSeparator();
        menu1.add(menu1Quit);

        m.add(menu1);

            //>// Menu 2 ////

        JMenu menu2 = new JMenu("About");
        JMenuItem menu2About = new JMenuItem("Author");
        menu2About.addActionListener(this);

        menu2.add(menu2About);

        m.add(menu2);

        this.setJMenuBar(m);
        this.setVisible(true);

        //// Panel Colors ////

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(2,4));

        JButton black    = new JButton("Black");
        JButton yellow   = new JButton("Yellow");
        JButton red      = new JButton("Red");
        JButton pink     = new JButton("Pink");
        JButton green    = new JButton("Green");
        JButton magenta   = new JButton("Magenta");
        JButton blue     = new JButton("Blue");
        JButton orange   = new JButton("Orange");

        black.  setBackground(Color.black);
        black.  setForeground(Color.white);
        yellow. setBackground(Color.yellow);
        red.    setBackground(Color.red);
        pink.   setBackground(Color.pink);
        green.  setBackground(Color.green);
        magenta.setBackground(Color.magenta);
        blue.   setBackground(Color.blue);
        orange. setBackground(Color.orange);

        black.  addActionListener(this);
        yellow. addActionListener(this);
        red.    addActionListener(this);
        pink.   addActionListener(this);
        green.  addActionListener(this);
        magenta.addActionListener(this);
        blue.   addActionListener(this);
        orange. addActionListener(this);

        colorPanel.add(black);
        colorPanel.add(yellow);
        colorPanel.add(red);
        colorPanel.add(pink);
        colorPanel.add(green);
        colorPanel.add(magenta);
        colorPanel.add(blue);
        colorPanel.add(orange);

        /// Panel Figures ////

        JPanel figurePanel = new JPanel();
        figurePanel.setLayout(new GridLayout(2,2));

        JButton ellipse     = new JButton("Ellipse");
        JButton rectangle   = new JButton("Rectangle");
        JButton circle      = new JButton("Circle");
        JButton square      = new JButton("Square");

        ellipse     .addActionListener(this);
        rectangle   .addActionListener(this);
        circle      .addActionListener(this);
        square      .addActionListener(this);

        figurePanel.add(ellipse);
        figurePanel.add(rectangle);
        figurePanel.add(circle);
        figurePanel.add(square);

        //// South Panel ////

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));

        contentPanel.add(southPanel,"South");
        southPanel  .add(colorPanel,"West");
        southPanel  .add(figurePanel,"East");
        this.setVisible(true);

        /// Paint.Drawing Panel ////

        this.drawing = new Drawing();

        contentPanel.add(this.drawing, "Center");

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "New" -> {
                System.out.println("You selected new!");
                drawing.removeAll();
                drawing.reset();
                this.setVisible(true);
            }
            case "Open" -> {
                drawing.recallDrawing();
                System.out.println("You selected open!");}
            case "Save" -> {
                drawing.saveDrawing();
                System.out.println("You selected save!");}
            case "Quit" -> {
                System.out.println("You selected quit!");
                dispose();}
            case "Author" -> {
                JOptionPane info = new JOptionPane();
                JOptionPane.showInternalMessageDialog( info, "Paint | Deluxe ultimate carnage reloaded edition by Ricardo SILVESTRE",
                        "Information",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("You selected author!");}
            case "Black" -> {
                drawing.setColor(Color.BLACK);
                System.out.println("You selected black!");}
            case "Yellow" -> {
                drawing.setColor(Color.YELLOW);
                System.out.println("You selected yellow!");}
            case "Red" -> {
                drawing.setColor(Color.RED);
                System.out.println("You selected red!");}
            case "Pink" -> {
                drawing.setColor(Color.PINK);
                System.out.println("You selected pink!");}
            case "Green" -> {
                drawing.setColor(Color.GREEN);
                System.out.println("You selected green!");}
            case "Magenta" -> {
                drawing.setColor(Color.MAGENTA);
                System.out.println("You selected magenta!");}
            case "Blue" -> {
                drawing.setColor(Color.BLUE);
                System.out.println("You selected blue!");}
            case "Orange" -> {
                drawing.setColor(Color.ORANGE);
                System.out.println("You selected orange!");}
            case "Paint.Circle" -> {
                drawing.setNameFigure("Paint.Circle");
                System.out.println("You selected a circle!");}
            case "Paint.Ellipse" -> {
                drawing.setNameFigure("Paint.Ellipse");
                System.out.println("You selected a ellipse!");}
            case "Paint.Rectangle" -> {
                drawing.setNameFigure("Paint.Rectangle");
                System.out.println("You selected a rectangle!");}
            case "Paint.Square" -> {
                drawing.setNameFigure("Paint.Square");
                System.out.println("You selected a square!");}
        }
    }

//    public void SaveFile() {
//        FileOutputStream file;
//        ObjectOutputStream out;
//        try {
//            file = new FileOutputStream(JOptionPane.showInputDialog(null, "save: "));
//            out = new ObjectOutputStream(file);
//            out.writeObject(this.drawing);
//            out.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public void OpenFile() {
        FileInputStream file_in;
        ObjectInputStream in;
        Container contentPane = getContentPane();
        contentPane.remove(this.drawing);
        try {
            file_in = new FileInputStream(JOptionPane.showInputDialog(null, "Open: "));
            in = new ObjectInputStream(file_in);
            this.drawing = (Drawing) in.readObject();
            contentPane.add(this.drawing);
            contentPane.revalidate();
            contentPane.repaint();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}