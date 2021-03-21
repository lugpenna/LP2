package figures;

import java.awt.*;

public class Elipse {
    private int x, y;
    private int w, h;
    private Color contorno;
    private Color fundo;

    public Elipse (int x, int y, int w, int h, Color contorno, Color fundo) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.contorno = contorno;
	this.fundo = fundo;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
        this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(contorno);
        g2d.drawOval(this.x,this.y, this.w,this.h);
		this.x+=1;this.y+=1;
		this.w-=1;this.h-=1;
		g2d.setColor(fundo);
		g2d.fillOval(this.x,this.y, this.w,this.h);
    }
}

