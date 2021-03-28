import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*; //Importando todo o pacote de figuras

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
	ArrayList<Elipse> es = new ArrayList<Elipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener ( //adicionando o ouvinte de teclas
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') { //criando retângulos randômicos ao teclar 'r'
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(75);
                        int h = rand.nextInt(75);
						int bgr = rand.nextInt(255);
						int bgg = rand.nextInt(255);
						int bgb = rand.nextInt(255);
						int bdr = rand.nextInt(255);
						int bdg = rand.nextInt(255);
						int bdb = rand.nextInt(255);
                         rs.add(new Rect(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint() avisa ao JFrame para redesenhar
                    }
					else if (evt.getKeyChar() == 'e') { //criando elipses randômicas ao teclar 'e'
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(75);
                        int h = rand.nextInt(75);
						int bgr = rand.nextInt(255);
						int bgg = rand.nextInt(255);
						int bgb = rand.nextInt(255);
						int bdr = rand.nextInt(255);
						int bdg = rand.nextInt(255);
						int bdb = rand.nextInt(255);
                        es.add(new Elipse(x,y, w,h,new Color(bgr,bgg,bgb),new Color(bdr,bdg,bdb)));
                        repaint();  // outer.repaint() avisa ao JFrame para redesenhar
                    }
                }
            }
        );

        this.setTitle("ListApp");
        this.setSize(500, 500);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }
		for (Elipse e: this.es) {
            e.paint(g);
        }
    }
}
