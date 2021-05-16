import java.awt.*;

import ivisible.IVisible;
import figures.Figure;

public class Button implements IVisible{ 
	private Figure fig;
	public Color fundo = Color.lightGray; 
	public int idx;
	
	public Button(int idx, Figure fig){ //Construtor do Botão
		this.idx = idx;
		this.fig = fig;
	}
	
	public boolean clicked(int x, int y){
        
		return false;
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		

		g2d.setColor(Color.black);
        	g2d.drawRect(0,40,45,45);
		g2d.setColor(fundo);
		g2d.fillRect(1,41,44,44);
		g2d.setColor(Color.black);
		g2d.drawRect(0,80,45,45);
		g2d.setColor(fundo);
		g2d.fillRect(1,81,44,44);
		g2d.setColor(Color.black);
		g2d.drawRect(0,120,45,45);
		g2d.setColor(fundo);
		g2d.fillRect(1,121,44,44);
		g2d.setColor(Color.black);
		g2d.drawRect(0,160,45,45);
		g2d.setColor(fundo);
		g2d.fillRect(1,161,44,44);
		
		this.fig.paint(g);

	}
}
