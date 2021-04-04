
package figures;

import java.awt.*;

public class Triangulo extends Figure {
    
    private int x1,x2,x3,y1,y2,y3;
    private int w, h;
    private Color contorno, fundo;
    

    public Triangulo (int x1,int x2,int x3,int y1,int y2,int y3, Color contorno, Color fundo) {
        this.x1 = x1;
	this.x2 = x2;
	this.x3 = x3;
        this.y1 = y1;
	this.y2 = y2;
	this.y3 = y3;
	this.contorno = contorno;
	this.fundo = fundo;
    }

    public void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(contorno);
		g2d.fillPolygon(new int[] {this.x1, this.x2, this.x3}, new int[] {this.y1, this.y2, this.y3}, 3);
		g2d.setColor(fundo);
	}
}
