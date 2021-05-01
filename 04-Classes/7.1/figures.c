#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int xpoints[3];
    int ypoints[3];
} Triangulo;

void Triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("Com os pontos: ");
    for (int i=0; i<3; i++) {
    	printf("(%d, %d)", this->xpoints[i], this->ypoints[i]);
	}
	printf("\n");
}

Triangulo* triangulo_new (int x, int y, int w, int h) {
    Triangulo* this = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangulo_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->xpoints[0] = x;
    this->xpoints[1] = x + w / 2;
    this->xpoints[2] = x + w;
    
    
    this->ypoints[0] = y + h;
    this->ypoints[1] = y;
    this->ypoints[2] = y + h;
    
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int xpoints[6];
    int ypoints[6];
} Hexagono;

void Hexagono_print (Hexagono* this) {
    Figure* sup = (Figure*) this;
    printf("Hexagono de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("Com os pontos: ");
    for (int i=0; i<3; i++) {
    	printf("(%d, %d)", this->xpoints[i], this->ypoints[i]);
	}
	printf("\n");
}

Hexagono* hexagono_new (int x, int y, int w, int h) {
    Hexagono* this = malloc(sizeof(Hexagono));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Hexagono_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->xpoints[0] = x;
    this->xpoints[1] = x + w / 3;
    this->xpoints[2] = x + 2 * w / 3;
    this->xpoints[3] = x + w;
    this->xpoints[4] = x + 2 * w / 3;
    this->xpoints[5] = x + w / 3;
    
    this->ypoints[0] = y + h / 2;
    this->ypoints[1] = y;
    this->ypoints[2] = y;
    this->ypoints[3] = y + h / 2;
    this->ypoints[4] = y + h;
    this->ypoints[5] = y + h;
}


///////////////////////////////////////////////////////////////////////////////
void main (void) {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) triangulo_new(150,100,120,100),
        (Figure*) triangulo_new(200,200,300,300),
	(Figure*) hexagono_new(100,75,170,100),
        (Figure*) hexagono_new(180,175,100,80)
    };

    ///

    for (int i=0; i<8; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<8; i++) {
        free(figs[i]);
    }
}
