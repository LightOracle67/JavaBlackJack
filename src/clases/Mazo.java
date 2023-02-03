package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import clases.Carta.Palo;
import excepciones.NoMoreCardsException;
/**
 * 
 * @author prgmsserv
 * CLASE MAZO - (Carta)
 */
public class Mazo {
	// Creamos la lista de Cartas como un List de Carta.
	public List<Carta> mazoCartas;

	public Mazo() {
		// La lista de Cartas pasa a ser un ArrayList de Carta.
		mazoCartas = new ArrayList<Carta>();
		// Para cada palo de Carta, devolvemos su valor.
		for (Palo paloCarta : Palo.values()) {
			// Para cada número de Carta, devolvemos también su número.
			for (int numeroCarta = 1; numeroCarta <= 13; numeroCarta++) {
				// Creamos el objeto Carta, donde se establecerá su número y su palo, dependiente del for.
				Carta carta = new Carta(numeroCarta, paloCarta);
				// Añadimos la carta creada a la ArrayList anterior.
				this.mazoCartas.add(carta);
			}
		}
	}
	// Función barajar([sin parámetros]) - Se encarga de mezclar todos los ítem de la lista, simulando el baraje.
	protected void barajar() {
		// Mezcla todos los ítems con Collections.shuffle.
		Collections.shuffle(this.mazoCartas);
	}

	@Override
	// Método toString([sin parámetros]) - devuelve, en este caso, todas las cartas de la ArrayList anterior.
	public String toString() {
		String i = "";
		// Para cada Carta en la lista (ArrayList), devuelve el toString de Carta y lo suma a la cadena.
		for (Carta carta : this.mazoCartas) {
			i = i + carta.toString()+"\n";
		}
		// Devuelve la cadena i.
		return i;
	}

	// Método solicitarCarta([sin parámetros]) - Devuelve la primera carta del mazo, y la elimina del mismo.
	protected Carta solicitarCarta() throws NoMoreCardsException{
		if(this.mazoCartas.size()==0) {
			throw new NoMoreCardsException();
		}
		this.barajar();
		// Creamos una nueva Carta, que es la primera del mazo.
		Carta devuelta = this.mazoCartas.get(0);
		// La eliminamos.
		mazoCartas.remove(0);
		// Y la devolvemos.
		return devuelta;
	}
}
