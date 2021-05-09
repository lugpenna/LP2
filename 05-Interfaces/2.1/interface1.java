/*
. Interface 1: 

. Objetos: Lâmpada, Lanterna de Pilha, Farol de Carro

. Adjetivo: ‘Luminável’

. Métodos: Ligar(), Desligar()

. Java:
*/

interface Luminavel{
	boolean ligar(boolean ligado);
	boolean desligar(boolean desligado);
}

class Lampada implements Luminavel{
	boolean ligar (boolean ligado){
	}
	boolean desligar (boolean desligado){
	}
}
class Lanterna implements Luminavel{
	boolean ligar (boolean ligado){	
	}
	boolean desligar (boolean desligado){
	}
}
class Farol implements Luminavel{
	boolean ligar (boolean ligado){	
	}
	boolean desligar (boolean desligado){
	}
}
