public class Reptil extends Animal{
	//Atributos
	private String corEscama;

	/*Métodos com a mesma assinatura
	em diferntes classes*/
	//Sobrepondo métodos de Animal
	@Override
	public void locomover(){
		System.out.println("\nRastejando.\n");
	}
	
	@Override
	public void alimentar(){
		System.out.println("\nCome vegetal.\n");	
	}
	
	@Override
	public void som(){
		System.out.println("\nSom de réptil.\n");	
	}
	
}
	
