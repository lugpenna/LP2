package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class Elipse extends Figure {
    Ellipse2D polygon;

    public Elipse (int x, int y, int w, int h, Color contorno, Color fundo) {//Construtor
        this.tipo = "Elipse";
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;

        this.espessura = 1;
        this.polygon = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	
	g2d.setColor(this.fundo);
        g2d.fill(this.polygon);
	
        g2d.setStroke(new BasicStroke(this.espessura));
        g2d.setColor(this.contorno);
        g2d.draw(this.polygon);        
    }

    public void drag (int x, int y, Point mouse_pos) {
        this.x += x;
        this.y += y;
        this.polygon = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }

    public boolean contains(MouseEvent evt) {
        if (this.polygon.contains(evt.getPoint()))
            return true;
        return false;
    }

    public void resize () {
        this.polygon = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }
}
