public class Ave extends Animal{
	//Atributos
	private String corEscama;
	
	/*Métodos com a mesma assinatura
	em diferntes classes*/
	//Sobrepondo métodos de Animal
	@Override
	public void locomover(){
		System.out.println("\nVoando.\n");
	}
	
	@Override
	public void alimentar(){
		System.out.println("\nComendo Minhoca.\n");	
	}

	@Override
	public void som(){
		System.out.println("\nAssobio.\n");	
	}
	
	//Métodos Públicos
	public void fazerNinho(){
		System.out.println("\nNinhoFeito.\n");	
		
	}
	
}
