public class Canguru extends Mamifero{
	//Métodos Públicos
	public void usarBolsa(){
		System.out.println("\nUsando Bolsa.\n");
	}
	
	/*Métodos com a mesma assinatura
	em diferntes classes*/
	@Override //Sobrepondo método de mamífero
	public void locomover(){
		System.out.println("\nSaltando.\n");
	}
}
