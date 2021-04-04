public abstract class Animal{ //Nada pode ser instanciado como animal
	//Atributos
	protected float peso;
	protected int idade;
	protected int membros;
	
	//Métodos Públicos
	public abstract void locomover();

	public abstract void alimentar();
	
	public abstract void som();

	//Métodos Especiais
	public float getPeso(){
		return peso;
	}

	public void setPeso(float peso){
		this.peso = peso;
	}

	public int getIdade(){
		return idade;	
	}
	
	public void setIdade(int idade){
		this.idade = idade;
	}

	public int getMembros(){
		return membros;
	}
	public void setMembros(int membros){
		this.membros = membros;
	}

	@Override
	public String toString(){//Status
		return "Animal{" +"peso  = "+peso+"\nidade = " +idade+
"\nmembros = "+membros+"}\n\n";
	} 
}

