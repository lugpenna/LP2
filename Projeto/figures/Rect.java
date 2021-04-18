package figures;

import java.awt.*;
import java.awt.event.*;

public class Rect extends Figure {
    Rectangle polygon;

    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {//Construtor
        this.tipo = "Retangulo";
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.contorno = contorno;
        this.fundo = fundo;
        this.espessura = 1;

        this.polygon = new Rectangle(this.x, this.y, this.w, this.h);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

	g2d.setPaint(this.contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        g2d.setStroke(new BasicStroke(this.espessura));
        g2d.setPaint(this.fundo);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }

    public void drag (int x, int y, Point mouse_pos) {
        this.x += x;
        this.y += y;
        this.polygon = new Rectangle(this.x, this.y, this.w, this.h);
    }

    public boolean contains(MouseEvent evt) {
        if (this.polygon.contains(evt.getPoint()))
            return true;
        return false;
    }

    public void resize () {
        this.polygon = new Rectangle(this.x, this.y, this.w, this.h);
    }
}
