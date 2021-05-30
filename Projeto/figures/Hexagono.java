package figures;

import java.awt.*;
import java.awt.event.*;


public class Hexagono extends Figure {
    private int x1,x2,x3,x4,x5,x6,y1,y2,y3,y4,y5,y6;
    private int x_vetor[], y_vetor[];
     private Polygon polygon;

    public Hexagono(int x, int y, int w, int h, Color contorno, Color fundo) {//Construtor
        super (x,y,w,h,contorno,fundo);
        
        this.tipo = "Hexagono";
	
	//propriedades hexagono
        this.x1 = x;
        this.y1 = y + h / 2;

        this.x2 = x + w / 3;
        this.y2 = y;

        this.x3 = x + 2 * w / 3;
        this.y3 = y;

        this.x4 = x + w;
        this.y4 = y + h / 2;

        this.x5 = x + 2 * w / 3;
        this.y5 = y + h;

        this.x6 = x + w / 3;
        this.y6 = y + h;

        int x_vet[] = {this.x1, this.x2, this.x3, this.x4, this.x5, this.x6};
        int y_vet[] = {this.y1, this.y2, this.y3, this.y4, this.y5, this.y6};
        this.x_vetor = x_vet;
        this.y_vetor = y_vet;

        this.espessura = 1.0f;
        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 6);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

	g2d.setColor(this.fundo);
        g2d.fillPolygon(this.polygon);

        g2d.setStroke(new BasicStroke(this.espessura));
        g2d.setColor(this.contorno);
        g2d.drawPolygon(this.polygon);
    }

    public void drag(int x, int y, Point mouse_pos) {
        this.x += x;
        this.y += y;

        for (int i = 0; i < this.x_vetor.length; i++) {
            this.x_vetor[i] += x;
            this.y_vetor[i] += y;
        }
        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 6);
    }

    public boolean contains(MouseEvent evt) {
        if (this.polygon.contains(evt.getPoint()))
            return true;
        return false;
    }

    public void resize () {
        this.x1 = x;
        this.y1 = y + h / 2;

        this.x2 = x + w / 3;
        this.y2 = y;

        this.x3 = x + 2 * w / 3;
        this.y3 = y;

        this.x4 = x + w;
        this.y4 = y + h / 2;

        this.x5 = x + 2 * w / 3;
        this.y5 = y + h;

        this.x6 = x + w / 3;
        this.y6 = y + h;

        int x_vet[] = {this.x1, this.x2, this.x3, this.x4, this.x5, this.x6};
        int y_vet[] = {this.y1, this.y2, this.y3, this.y4, this.y5, this.y6};
        this.x_vetor = x_vet;
        this.y_vetor = y_vet;

        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 6);
    }
    
	public boolean clicked(MouseEvent evt) {
			if (this.polygon.contains(evt.getPoint()))
				return true;
			return false;
	}
}
