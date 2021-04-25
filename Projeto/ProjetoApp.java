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
    boolean HUD = true;
    boolean mudafundo=false;
    boolean mudacontorno=false;
    Point pos;
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    float aux = 1;
    Color colors[] = {
        Color.WHITE, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW, 
        Color.GREEN, Color.GRAY, Color.MAGENTA, Color.ORANGE,
        Color.CYAN
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
                        focus.espessura = aux;
                    }

                    focus = null;

                    for (Figure fig: figs) {
                        if (fig.contains(evt)) {
                            focus = fig;
                            aux = focus.espessura;
                        }
                    }
                    
                    if (focus != null) {
                        focus.espessura = 3.0f;
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
		     Color contorno = colors[1];
		     Color fundo = colors[0];		     		   		     
                    if (mouse_pos == null) {
                        return;
                    }

                    if (evt.getKeyChar() == 'r') //cria retângulo
                        figs.add(new Rect(mouse_pos.x, mouse_pos.y, w, h, contorno, fundo));
                    else if (evt.getKeyChar() == 'e') //cria elipse
                        figs.add(new Elipse(mouse_pos.x, mouse_pos.y, w, h, contorno, fundo));
                    else if (evt.getKeyChar() == 't') //cria triângulo
                        figs.add(new Triangulo(mouse_pos.x, mouse_pos.y, w, h, contorno, fundo));
                    else if (evt.getKeyChar() == 'h') //cria hexagono
                        figs.add(new Hexagono(mouse_pos.x, mouse_pos.y, w, h, contorno, fundo));
                                                          
                    else if (evt.getKeyCode() == 127 & focus != null) { //deleta a figura selecionada 'delet'
                        figs.remove(focus);
                        focus = null;  
                        
                    
                    }else if (evt.getKeyCode() == 76) { //l limpa a tela
						
                        figs.clear();    
                    
                                     
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
                   } else if  (evt.getKeyCode() == 70){//f ativando alteração de cor de fundo
                   	mudafundo = true;
                   	mudacontorno = false; 
                   } else if (evt.getKeyCode() == 48 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 0 = fundo branco						
						focus.corfundo(colors[0]);
                   } else if (evt.getKeyCode() == 49 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 1 = fundo preto				
						focus.corfundo(colors[1]);
                   } else if (evt.getKeyCode() == 50 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 2 = fundo azul						
						focus.corfundo(colors[2]);
                   } else if (evt.getKeyCode() == 51 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 3 = fundo vermelho						
						focus.corfundo(colors[3]);
		   } else if (evt.getKeyCode() == 52 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 4 = fundo amarelo						
						focus.corfundo(colors[4]);
                   } else if (evt.getKeyCode() == 53 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 5 = fundo verde						
						focus.corfundo(colors[5]);
                   } else if (evt.getKeyCode() == 54 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 6 = fundo cinza					
						focus.corfundo(colors[6]);
                   } else if (evt.getKeyCode() == 55 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 7 = fundo magenta						
						focus.corfundo(colors[7]);
                   } else if (evt.getKeyCode() == 56 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 8 = fundo laranja						
						focus.corfundo(colors[8]);
		   } else if (evt.getKeyCode() == 57 & mudafundo == true & mudacontorno == false & focus != null) {//f ativado + 9 = fundo cyano						
						focus.corfundo(colors[9]);
		     
                   
                                                                                                                                                                                                    
                   } else if  (evt.getKeyCode() == 67){//c ativando a alteração de contorno
                   	mudafundo = false;
                   	mudacontorno = true;
                   }
                    
                    
                    
                    else if (evt.getKeyCode() == 48 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 0 = contorno branco						
						focus.corcontorno(colors[0]);
                    } else if (evt.getKeyCode() == 49 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 1 = contorno  preto
						
						focus.corcontorno(colors[1]);
                    } else if (evt.getKeyCode() == 50 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 2 = contorno azul						
						focus.corcontorno(colors[2]);
                    } else if (evt.getKeyCode() == 51 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 3 = contorno vermelho						
						focus.corcontorno(colors[3]);
		    } else if (evt.getKeyCode() == 52 & mudafundo == true & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 4 = contorno amarelo						
						focus.corcontorno(colors[4]);
                    } else if (evt.getKeyCode() == 53 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 5 = contorno verde						
						focus.corcontorno(colors[5]);
                    } else if (evt.getKeyCode() == 54 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 6 = contorno cinza						
						focus.corcontorno(colors[6]);
                    } else if (evt.getKeyCode() == 55 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 7 = contorno magenta						
						focus.corcontorno(colors[7]);
                    } else if (evt.getKeyCode() == 56 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 8 = contorno laranja						
						focus.corcontorno(colors[8]);
		    } else if (evt.getKeyCode() == 57 & mudafundo == false & mudacontorno == true & focus != null) {//c ativado + 9 = contorno ciano						
						focus.corcontorno(colors[9]);
		    }
                    

                    else if (evt.getKeyCode() == 10){ //Enter para controle da HUD
                    	if (HUD == true){
                        	HUD = false;
                    	}
                    	else{
                        	HUD = true;
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
	Graphics2D graficos = (Graphics2D) g;
        super.paint(g);

        for (Figure fig: this.figs) {
            fig.paint(g);
        }
	if (HUD == true){
            graficos.setColor(Color.black);
            graficos.setFont(new Font("Fonte", 3 , 13));
            graficos.drawString("Enter : Mostrar/Ocultar HUD", 5, 50);
            graficos.drawString("R : Criar Retângulo ", 5, 65);
            graficos.drawString("E : Criar Elipse", 5, 80);
            graficos.drawString("T : Criar Triângulo", 5, 95);
            graficos.drawString("H : Criar Hexagono", 5, 110);
            graficos.drawString("C : Seleciona cor de contorno para mudança", 5, 125);
            graficos.drawString("F : Seleciona cor de fundo para mudança", 5, 140);
            graficos.drawString("0 a 9 : Altera a cor do que foi selecionado ", 5, 155);
            graficos.drawString("Delete : Deleta a figura selecionada", 5, 170);
            graficos.drawString("Botão Esquerdo do Mouse : Seleciona uma figura", 5, 185);
            graficos.drawString("Arrasto de Mouse : Muda de posição a figura selecionada", 5, 200);
            graficos.drawString("Setas : Redimensiona figura selecionada", 5, 215);
            graficos.drawString("L : Limpa a tela", 5, 230);
        }
    }
}
