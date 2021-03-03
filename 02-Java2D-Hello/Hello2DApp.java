import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
		frame.getContentPane().setBackground(Color.yellow); //alteração da cor de fundo 1a modificação 
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(1000, 1000);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        //g2d.drawLine(0,0, w,h);
        //g2d.drawLine(0,h, w,0);
	g2d.setPaint(Color.white);
	g2d.fillRect(150,150,700,500); // construção retângulo 2a modificação 
	g2d.setPaint(Color.red);
	g2d.fillOval(350,250,300,300); // construção círculo 3a modificação
    }
	
}
