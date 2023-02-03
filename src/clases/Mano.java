package clases;

import java.util.ArrayList;
import excepciones.NoMoreCardsException;
/**
 * 
 * @author prgmsserv
 *	CLASE MAZO --> MANO (sin parámetros)
 */
public class Mano extends Mazo {
	//Contructor sin parámetros.
	protected Mano() {
		// Creamos la lista de Cartas del Jugador como un List de Carta.
		super();
		this.mazoCartas = new ArrayList<Carta>();
		// Y la establecemos como vacía.
		this.mazoCartas.clear();
	}
	
	// Método valorMano([sin parámetros]) - Devuelve el valor completo de la mano.
	protected int valorMano() {
		// Establecemos el valor inicial a 0.
		int valor = 0;
		// Para cada carta en la mano del jugador:
		for (Carta carta : this.mazoCartas) {
			// El valor es el valor más el valor de la carta.
			valor = valor + carta.getValor();
		}
		// Devuelve la suma de valor.
		return valor;
	}
	
	// Método findeJuego([sin parámetros]) - Dependiendo de si se cumple o no la condición, devuelve true o false.
	protected boolean findeJuego() {
		// Si el valor de la mano completa es mayor o igual a 21, devuelve true.
		if (valorMano() >= 21) {
			return true;
		}
		// En cualquier otro caso, devuelve false.
		return false;
	}

	@Override
	// Método toString([sin parámetros]) - Devuelve todas las cartas de la mano.
	public String toString() {
		// Establecemos una cadena vacía, que se devolverá.
		String i = "Valor de la Mano: "+this.valorMano()+"\n";
		// Y devolvemos la cadena completa, junto al toString de la clase padre (super).
		i=i+super.toString();
		return i;

	}
	
	// Método pedirCarta(Mazo) 
	public void pedirCarta(Mazo m) throws NoMoreCardsException {
		// A la mano del jugador, se le añade una carta, que se solicita al Mazo parametrizado.
		this.mazoCartas.add(m.solicitarCarta());
	}

}
