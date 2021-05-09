/*
. Interface 2: 

. Objetos: Teclado de Computador, Máquina de Escrever, Touchpad

. Adjetivo: ‘Teclável’

. Métodos: teclar(), pressionar()

. Java:
*/

interface Teclavel{
int teclar(int f);
int pressionar(int f);
}

class Teclado implements Teclavel{
	void teclar (int f){ //f = parâmetro força
	}
	void pressionar (int f){	
	}
}

class Maquina implements Teclavel{
	void teclar (int f){
	}
	void pressionar (int f){	
	}
}
class Touchpad implements Teclavel{
	void teclar (int f){
	}
	void pressionar (int f){	
	}
}
