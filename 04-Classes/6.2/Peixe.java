public class Peixe extends Animal{
	//Atributos
	private String corEscama;
	
	/*Métodos com a mesma assinatura
	em diferntes classes*/
	//Sobrepondo métodos de Animal
	@Override
	public void locomover(){
		System.out.println("\nNadando.\n");
	}
	
	@Override
	public void alimentar(){
		System.out.println("\nComendo Plank.\n");	
	}

	@Override
	public void som(){
		System.out.println("\nGlub.\n");	
	}
	
	//Métodos Públicos
	public void soltarBolha(){
		System.out.println("\nSoltou Bolha.\n");	
		
	}
	
}
