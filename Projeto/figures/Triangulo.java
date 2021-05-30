package figures;

import java.awt.*;
import java.awt.event.*;

public class Triangulo extends Figure {
    private int x_vetor[], y_vetor[];
    private int x1, x2, x3;
    private int y1, y2, y3;
    private Polygon polygon;

    public Triangulo (int x, int y, int w, int h, Color contorno, Color fundo) {//Construtor
        super (x,y,w,h,contorno,fundo);
        
        this.tipo = "Triangulo";

	//propriedades triangulo
        this.x1 = x;
        this.y1 = y + h;

        this.x2 = x + w / 2;
        this.y2 = y;

        this.x3 = x + w;
        this.y3 = y + h;

        int x_vet[] = {this.x1, this.x2, this.x3};
        int y_vet[] = {this.y1, this.y2, this.y3};
        this.x_vetor = x_vet;
        this.y_vetor = y_vet;

        this.espessura = 1.0f;
        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 3);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(this.fundo);
        g2d.fillPolygon(this.polygon);

        g2d.setStroke(new BasicStroke(this.espessura));
        g2d.setColor(this.contorno);
        g2d.drawPolygon(this.polygon);
    }

    public void drag (int x, int y, Point mouse_pos) {
        this.x += x;
        this.y += y;

        for (int i = 0; i < this.x_vetor.length; i++) {
            this.x_vetor[i] += x;
            this.y_vetor[i] += y;
        }
        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 3);
    }

    public boolean contains(MouseEvent evt) {
        if (this.polygon.contains(evt.getPoint()))
            return true;
        return false;
    }

    public void resize () {
        this.x1 = x;
        this.y1 = y + h;

        this.x2 = x + w / 2;
        this.y2 = y;

        this.x3 = x + w;
        this.y3 = y + h;

        int x_vet[] = {this.x1, this.x2, this.x3};
        int y_vet[] = {this.y1, this.y2, this.y3};
        this.x_vetor = x_vet;
        this.y_vetor = y_vet;

        this.polygon = new Polygon(this.x_vetor, this.y_vetor, 3);
    }
    
	public boolean clicked(MouseEvent evt) {
			if (this.polygon.contains(evt.getPoint()))
				return true;
			return false;
	}
    
}
