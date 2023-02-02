package clases;

/**
 * 
 * @author prgmsserv
 *	CLASE CARTA - (numero,palo);
 */

public class Carta {
	// Palo - Enumerado que muestra los 4 palos asignables a una carta.
	protected enum Palo {
		// Tipos:
			Tréboles,Diamantes,Corazones,Picas
	};
	// Numero - Rango comprendido entre 1 y 13.
	protected int numero;
	protected Palo palo;
	// Vector representa[] - Representación de texto de las cartas
	protected static final String representa[] = {"AS","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	// Constructor de Carta(numero,palo) - El número y el palo a asignar son los parámetros.
	protected Carta(int numero,Palo palo){
		this.numero = numero;
		this.palo = palo;
	}

	/**
	 * @return el numero
	 */
	// Devuelve el número de la carta.
	protected int getNumero() {
		return numero;
	}

	/**
	 * @return el palo
	 */
	// Devuelve el palo de la carta.
	protected Palo getPalo() {
		return palo;
	}
	
	// Función getValor([sin parámetros]) - Devuelve el valor asignado a una carta.
	protected int getValor() {
		 int valor;
		 // Si el número es 1 (AS) el valor devuelto será 11.
		 if(this.numero==1) {
			 valor=11;
			 //Si está entre 11 y 13, devuelve 10.
		 }else if(this.numero>10 && this.numero<=13) {
			 valor=10;
		 }else {
			 // En cualquier otro caso, devuelve el número de la carta.
			 valor=this.numero;
		 }
		 // Devolver valor.
		 return valor;
	}
	
	// Función mostrarNumero([sin parámetros]) - Devuelve la representación del número de la carta.
	protected String mostrarNumero() {
		return representa[this.numero-1];
	}

	@Override
	// Método toString - Devuelve el número de la carta y su palo.
	public String toString() {
		return this.mostrarNumero() + " - " + this.palo;
	}
	
}
