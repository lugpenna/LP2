import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Elipse e1;
    Triangulo t1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(500, 500);
        this.r1 = new Rect(100,100,100,60, Color.cyan, Color.orange);
        this.e1 = new Elipse(50,200,150,60, Color.red, Color.green);
        this.t1 = new Triangulo(250,350,300, 100, 100, 250, Color.red, Color.black);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.t1.paint(g);
    }
}
