#include <stdio.h>

typedef struct{
	int x, y;
	int w, h;
} Polig;

void print ( Polig* p){
	printf("Polígono de tamanho (%d, %d) na posição (%d, %d).\n",
           p->w, p->h, p->x, p->y);
}

void main (void){
	Polig p1 = {1, 1, 10, 10};
	print(&p1);
}
