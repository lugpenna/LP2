import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

public class ProjetoApp {
    public static void main(String[] args) {
        List_frame frame = new List_frame();
        frame.setVisible(true);
    }
}

class List_frame extends JFrame {
    Point pos;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Color aux = null, colors[] = {
        Color.WHITE, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, 
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.GRAY,
        Color.CYAN, Color.DARK_GRAY
    };
    Random rand = new Random();

    List_frame() {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addMouseListener ( //Listener para o foco
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    pos = getMousePosition();
                    if (focus != null) {
                        focus.contorno = aux;
                    }

                    focus = null;

                    for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                            focus = fig;
                            aux = focus.contorno;
                        }
                    }
                    
                    if (focus != null) {
                        focus.contorno = Color.RED;
                        figs.remove(focus);
                        figs.add(focus);
                    }

                    repaint();
                }
            }
        );

        this.addMouseMotionListener ( //Listener para arrastar as figuras com o mouse
            new MouseMotionAdapter() {
                public void mouseDragged (MouseEvent evt) {
                    if (focus != null) {
                        if (pos != null)
                            focus.drag(evt.getX() - pos.x, evt.getY() - pos.y, evt.getPoint());
                        pos = getMousePosition();
                        repaint();
                    }
                }
            }
        );

        this.addKeyListener ( //Listener para interação com o teclado
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    Point mouse_pos = getMousePosition();
		     int w = 30;
		     int h = 30;		     		   		     
                    if (mouse_pos == null) {
                        return;
                    }

                    if (evt.getKeyChar() == 'r') //cria retângulo
                        figs.add(new Rect(mouse_pos.x, mouse_pos.y, w, h, Color.BLACK, Color.WHITE));
                    else if (evt.getKeyChar() == 'e') //cria elipse
                        figs.add(new Elipse(mouse_pos.x, mouse_pos.y, w, h, Color.BLACK, Color.WHITE));
                    else if (evt.getKeyChar() == 't') //cria triângulo
                        figs.add(new Triangulo(mouse_pos.x, mouse_pos.y, w, h, Color.BLACK, Color.WHITE));
                    else if (evt.getKeyChar() == 'h') //cria hexagono
                        figs.add(new Hexagono(mouse_pos.x, mouse_pos.y, w, h, Color.BLACK, Color.WHITE));  
                                                          
                    else if (evt.getKeyCode() == 127 & focus != null) { //deleta a figura selecionada 'delet'
                        figs.remove(focus);
                        focus = null;                   
                    } else if (evt.getKeyCode() == 39 & focus != null) {// aumenta a largura da figura selecionada 'seta direita'
                        if (focus.w < 400) {
                            focus.w += 1;
                            focus.resize();
                        }
                    } else if (evt.getKeyCode() == 37 & focus != null) {// diminui a largura da figura selecionada 'seta esquerda'
                        if (focus.w > 5) {
                            focus.w -= 1;
                            focus.resize();
                        }
                    } else if (evt.getKeyCode() == 40 & focus != null) {//diminui a altura da figura selecionada 'seta baixo'
                        if (focus.h > 5) {
                            focus.h -= 1;
                            focus.resize();
                        }
                    } else if (evt.getKeyCode() == 38 & focus != null) {//aumenta a altura da figura selecionada 'seta cima'
                        if (focus.h < 400) {
                            focus.h  += 1;
                            focus.resize();
                        }
                    }
                    repaint(); 
                }
            }
        );

        this.setTitle("Projeto App");
        this.setSize(700, 700);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
