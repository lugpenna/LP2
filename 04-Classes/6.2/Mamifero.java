public class Mamifero extends Animal{
	//Atributos
	private String corPelo;
	
	/*Polimorfismo por sobreposição:
	Métodos que assumem formas diferentes
	com a mesma assinatura e em classes diferentes*/	
	//Sobrepondo métodos de Animal
	@Override
	public void locomover(){
		System.out.println("\nCorrendo.\n");
	}
	
	@Override
	public void alimentar(){
		System.out.println("\nMamando.\n");	
	}

	@Override
	public void som(){
		System.out.println("\nSom de mamífero.\n");	
	}
	
}
	
