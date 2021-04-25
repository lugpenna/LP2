package figures;

import java.awt.*;
import java.awt.event.*;

public abstract class Figure { //Superclasse
    public int x, y;
    public int w, h;
    public Color contorno, fundo;
    public float espessura;
    public String tipo;
    
    public abstract void paint(Graphics g);
    public abstract void drag(int x, int y, Point mouse_pos);
    public abstract boolean contains(MouseEvent evt);
    public abstract void resize();
    
    public void corfundo(Color fundo){
		this.fundo=fundo;
	}
	
	public void corcontorno(Color contorno){
		this.contorno=contorno;
	}

    public void print () {
        System.out.format("%s de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.tipo, this.w, this.h, this.x, this.y);
    }
}
