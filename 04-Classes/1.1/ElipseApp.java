public class ElipseApp{
	public static void main (String[] args){
	Elipse e1 = new Elipse (0, 5, 4, 5, 2, 4, 3, 2, 5);
	e1.print();
	}
}

        class Elipse {
	
	int f1x;//Foco 1 x
	int f1y;//Foco 1 y
	int f2x;//Foco 2 x
	int f2y;//Foco 2 y

	int c;//2c=Distância Focal
	int a;//2a=Eixo Maior
	int b;//2b=Eixo Menor
	
	//c/a=excentricidade
	//a²=b²+c²
	
	int cx;//Centro da Elipse x
	int cy;//Centro da Elipse y



	Elipse (int f1x, int f1y, int f2x, int f2y, int c, int a, int b, int cx, int cy){
		this.f1x = f1x;
		this.f1y = f1y;
		this.f2x = f2x;
		this.f2y = f2y;
		this.c = c;
		this.a = a;
		this.b = b;
		this.cx = cx;
		this.cy = cy;
}
	void print() {
		System.out.println("Posição F1 x: "+this.f1x);
		System.out.println("Posição F1 y: "+this.f1y);
		System.out.println("Posição F2 x: "+this.f2x);		    
		System.out.println("Posição F2 y: "+this.f2y);
		System.out.println("C: "+this.c);
		System.out.println("A: "+this.a);
		System.out.println("B: "+this.b);		    
		System.out.println("Centro x: "+this.cx);
		System.out.println("Centro y: "+this.cy);
	}
}
