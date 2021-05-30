package ivisible;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public interface IVisible {
    public void paint(Graphics g);
    public boolean clicked(MouseEvent evt);

}
