#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect {
	int w, h, x, y;
} Rect;

Rect* rect_new (void) {
	Rect* this = malloc(sizeof(Rect));
	this->w = 30;
	this->h = 20;
	this->x = 15;
	this->y = 30;
	
}

void rect_drag (Rect* this, int dx, int dy) {
	this->x += dx;
	this->y += dy;
}
void rect_print (Rect* this) {
	printf("Retangulo na posição (%d,%d) com tamanho (%d,%d).\n", this->x, this->y, this->w, this->h);
}
