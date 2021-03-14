public class ElipseApp{
	public static void main (String[] args){
	Elipse e1 = new Elipse (0, 5, 4, 5, 2, 4, 3, 2, 5);
	e1.print();
	}
}

        class Elipse {
	
	float f1x;//Foco 1 x
	float f1y;//Foco 1 y
	float f2x;//Foco 2 x
	float f2y;//Foco 2 y

	float c;//2c=Distância Focal
	float a;//2a=Eixo Maior
	float b;//2b=Eixo Menor
	
	
	float cx;//Centro da Elipse x
	float cy;//Centro da Elipse y



	Elipse (float f1x, float f1y, float f2x, float f2y, float c, float a, float b, float cx, float cy){
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
		System.out.println("F1 x: "+this.f1x);
		System.out.println("F1 y: "+this.f1y);
		System.out.println("Posição F2 x: "+this.f2x);		    
		System.out.println("Posição F2 y: "+this.f2y);
		System.out.println("C: "+this.c);
		System.out.println("A: "+this.a);
		System.out.println("B: "+this.b);		    
		System.out.println("Centro x: "+this.cx);
		System.out.println("Centro y: "+this.cy);
	}
}
