# Polimorfismo com despacho dinâmico

É uma característica de linguagens orientadas a objeto, onde é possível chamar diferentes métodos de mesmo nome a partir de diferentes classes. 
Segue exemplo:
## Classe Animal

    public abstract class Animal{ //Nada pode ser instanciado como animal
	    //Atributos
	    protected float peso;
	    protected int idade;
	    protected int membros;
	
	    //Métodos Públicos
	    public abstract void locomover();

	    public abstract void alimentar();
	
	    public abstract void som(); //Código continua...          
### Classe Ave
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
### Classe Peixe
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

Observa-se que nos códigos acima descrevem-se superclasses com o método som(), alimentar() e locomover(), em que suas classes derivadas Peixe e Ave o herdam porém sobrepondo sua funcionalidade ao alterarem seu bloco de execução.

Esse tipo de polimorfismo ocorre em tempo de execução e seus métodos herdados devem conter o mesmo número de argumentos de sua implementação na superclasse, pois caso contrário o método já não seria mais o mesmo.

### Programa Principal
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
    
Observando o código anterior, o método a ser executado é determinado com base no tipo de objeto em contexto no momento da chamada (despacho dinâmico).

Dessa forma, a vinculação dinâmica trata-se de executar uma mesma tarefa para diferentes contextos específícos de uma classe com suas próprias implementações, sendo assim útil pela sua simplicidade e reutilização de código.

#### Bibliografia
* Curso em Vídeo: https://www.youtube.com/watch?v=NctjqlfKC0U&list=PLHz_AreHm4dkqe2aR0tQK74m8SFe-aGsY&index=27
* DevMedia: https://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140

  
     
    
