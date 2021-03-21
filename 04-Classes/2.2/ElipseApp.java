import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ElipseApp
{
    public static void main (String[] args)
    {
        ElipseFrame frame = new ElipseFrame();
        frame.setVisible(true);
    }
}

class ElipseFrame extends JFrame
{
    // Criando 3 elipses
    Elipse e1;
    Elipse e2;
    Elipse e3;
    

    ElipseFrame()
    {
        
        this.addWindowListener (
            new WindowAdapter()
            {
                public void windowClosing (WindowEvent e)
                {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Elipse App");
        this.setSize(500,500);
        this.e1 = new Elipse(150, 150, 70, 100, Color.black, Color.yellow);
        this.e2 = new Elipse(40, 180, 60, 120, Color.green, Color.black);
        this.e3 = new Elipse(180, 90, 70, 40, Color.cyan, Color.magenta);
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        
    }
}

class Elipse
{

    int x, y;
    int w, h;
    Color fundo;
    Color contorno;

    //Adicionando propriedades de contorno e fundo na classe
    Elipse (int x, int y, int w, int h, Color fundo, Color contorno)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }
    
    void print ()
    {
        System.out.format("Elipse de tamanho (%d, %d) na posicao (%d, %d) \n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fundo);
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(contorno);
        g2d.drawOval(this.x, this.y, this.w, this.h);

    }
}
