package figures;

import java.awt.*;
import java.awt.event.*;

public class Rect extends Figure {
    private Rectangle polygon;

    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {//Construtor
        super (x,y,w,h,contorno,fundo);
        this.espessura = 1.0f;
        this.polygon = new Rectangle(this.x, this.y, this.w, this.h);
        this.tipo = "Retangulo";
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	
	g2d.setStroke(new BasicStroke(this.espessura));
	g2d.setPaint(this.contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        

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
        
	public boolean clicked(MouseEvent evt) {
			if (this.polygon.contains(evt.getPoint()))
				return true;
			return false;
	}
       
}
