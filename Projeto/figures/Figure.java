package figures;
import ivisible.IVisible;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable { //Superclasse
    public int x, y, w, h;
    public Color contorno, fundo;
    public float espessura;
    public String tipo;
    
    protected Figure(int x, int y,int w,int h, Color contorno, Color fundo){
        this.x=x;
        this.y=y;
        this.h=h;
        this.w=w;
        this.contorno=contorno;
        this.fundo=fundo;
    }
    
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
    
        public abstract boolean clicked(MouseEvent evt);
}
