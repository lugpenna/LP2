import java.awt.*;

import ivisible.IVisible;
import figures.Figure;
import java.awt.event.*;

public class Button implements IVisible {
    public int x, y;
    public int idx;
    public Figure figs;
    public boolean focused;

    public Button(int idx, Figure figs) {
        this.idx = idx;
        this.figs = figs;
        this.focused = false;

        this.x = 0;
        this.y = 35 + idx * 40;
    }

    public boolean clicked(MouseEvent evt) {
        if (evt.getX() >= this.x && evt.getX() <= this.x + 30 && evt.getY() >= this.y && evt.getY() <= this.y + 30)
            return true;

        return false;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(1));

        if (this.focused)
            g2d.setPaint(Color.DARK_GRAY);
        else
            g2d.setPaint(Color.GRAY);

        g2d.fillRect(this.x, this.y, 40, 40);

        g2d.setPaint(Color.BLACK);
        g2d.drawRect(this.x, this.y, 40, 40);

        this.figs.paint(g);
    }
}
