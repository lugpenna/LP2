package figures;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
    protected int x, y,x1,x2,x3,y1,y2,y3;
    protected int w, h;
    protected Color contorno, fundo;
    
    public abstract void paint (Graphics g);
}
