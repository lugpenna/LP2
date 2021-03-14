public class PoligonoApp{
	public static void main (String[] args){
	Poligono p1 = new Poligono (15, 20, 10, 10);
	p1.print();
	}
}

        class Poligono {
	
	int altura;
	int largura;
	
	int x;
	int y;

	Poligono (int altura, int largura, int x, int y){
		this.altura = altura;
		this.largura = largura;
		this.x = x;
		this.y = y;
}
	void print() {
		System.out.println("Altura: "+this.altura);
		System.out.println("Largura: "+this.largura);
		System.out.println("Posição x: "+this.x);		    
		System.out.println("Posição y: "+this.y);
	}
}
