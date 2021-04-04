public class Main{
	public static void main (String[] args){
		Mamifero m = new Mamifero();
		Reptil r = new Reptil();
		Peixe p = new Peixe();
		Ave a = new Ave();
		Canguru c = new Canguru();
		
		m.setPeso(85.2f);
		m.setIdade(2);
		m.setMembros(4);
		m.locomover(); //Correndo
		m.alimentar(); //Mamando
		m.som(); //Som de Mamífero

		c.setPeso(13f);
		c.setIdade(38);
		c.setMembros(4);
		c.locomover(); //Saltando
		c.alimentar(); //Mamando
		c.som(); //Som de Mamífero
		
		p.setPeso(1.2f);
		p.setIdade(1);
		p.locomover(); //Nadando
		p.alimentar(); //Comendo plank
		p.som(); //Glub
		
		a.setPeso(5.2f);
		a.setIdade(4);
		a.locomover(); //Voando
		a.alimentar(); //Comendo Minhoca
		a.som(); //Assobio

	}
}
