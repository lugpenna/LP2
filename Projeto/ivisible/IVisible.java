package ivisible;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public interface IVisible {
    void paint(Graphics g);
    boolean clicked(MouseEvent evt);

}
