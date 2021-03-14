#include <stdio.h>

typedef struct{
	int f1x, f1y;
	int f2x, f2y;
	int c, a, b;
	int cx, cy;
} Elipse;

void print ( Elipse* e){
	printf("Foco 1: (%d,%d)\nFoco 2: (%d,%d)\nC: (%d)\nA: (%d)\nB: (%d)\nCentro: (%d,%d)\n",
           e->f1x, e->f1y, e->f2x, e->f2y, e->c, e->a, e->b, e->cx, e->cy);
}

void main (void){
	Elipse e = {0, 5, 4, 5, 2, 4, 3, 2, 5};
	print(&e);
}
