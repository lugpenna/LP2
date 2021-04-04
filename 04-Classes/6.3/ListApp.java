import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Color cor[] = { Color.blue, Color.black, Color.cyan, Color.gray, Color.green,
                    Color.magenta, Color.orange, Color.red, Color.yellow };

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                   int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(300);
                    int h = rand.nextInt(300);
                    int x1 = rand.nextInt(350);
                    int x2 = rand.nextInt(350);
                    int x3 = rand.nextInt(350);
                    int y1 = rand.nextInt(350);
                    int y2 = rand.nextInt(350);
                    int y3 = rand.nextInt(350);
                    int contorno = rand.nextInt(8);
                    int fundo = rand.nextInt(8);

                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h, cor[contorno],cor[fundo]));
                    } 
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Elipse(x,y, w,h, cor[contorno],cor[fundo]));
                    } 
                    else if (evt.getKeyChar() == 't') {
                        figs.add(new Triangulo(x1,x2,x3,y1,y2,y3,cor[contorno],cor[fundo]));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
