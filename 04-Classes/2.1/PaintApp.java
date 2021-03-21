import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    // Criando 3 retângulos
    Rect r1;
    Rect r2;
    Rect r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Paint App");
        this.setSize(500, 500);
        this.r1 = new Rect(50,50, 100,30, Color.blue, Color.red);
        this.r2 = new Rect(150, 150, 150, 80, Color.red, Color.green);
        this.r3 = new Rect(250, 250, 80, 150, Color.orange, Color.pink);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color fundo;
    Color contorno;

    //Adicionando propriedades de contorno e fundo na classe
    Rect (int x, int y, int w, int h, Color fundo, Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }
    

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fundo);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
