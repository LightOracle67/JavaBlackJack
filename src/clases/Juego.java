package clases;

import java.util.Scanner;
/**
 * 
 * @author prgmsserv
 *	CLASE JUEGO - EJECUCIÓN.
 */
public class Juego {
	// Variable de control.
	protected static String volverajugar = "S";
	// Variable que define el mazo completo.
	private static Mazo mazoJuego;
	// Variable que define la mano de la máquina (Banca)
	private static Mano manoMaquina;
	// Variable que define la mano del jugador
	private static Mano manoJugador;

	// Ejecutor
	public static void main(String[] args) {
		System.out.println("¡Bienvenido al BlackJack!");
		System.out.println(
				"Las normas son simples:\nEl jugador deberá coger cartas,\nhasta superar o igualar los\n21 puntos.\nEl juego te avisará automáticamente\nsi te pasas (pierdes),\no si igualas los 21 puntos (ganas).");
		mazoJuego = new Mazo();
		manoJugador = new Mano();
		juego(mazoJuego, manoJugador);
	}
//FUNCIÓN juego(mazo a jugar,mano a jugar) - Genera el juego utilizando el mazo y la mano que se le pasen como parámetros.
	protected static void juego(Mazo mazoJuego, Mano manoJugador) {
		// mazoJuego.barajar([sin parámetros]) - Se encarga de mezclar todos los ítem del mazo.
					mazoJuego.barajar();
		// Si la mano del jugador no tiene más de 21 puntos, cumpliendo la condición de
		// no terminar el juego, ejecuta el código.
		while(!manoJugador.findeJuego()) {
			// Confirmación 1
			// Scanner para pedir confirmación por teclado
			Scanner teclado = new Scanner(System.in);
				// Confirmación 1 - Coger carta
				System.out.println("¿Coger carta? - (S/N)");
				String quierecarta = teclado.nextLine();
				if (quierecarta.equals("S") || quierecarta.equals("s")) {
					// Pide carta al mazo
					manoJugador.pedirCarta(mazoJuego);
					// Muestra los datos
					System.out.println(
							"Tu mano tiene " + manoJugador.valorMano() + " puntos.\nCartas:\n" + manoJugador.toString());
					juego(mazoJuego, manoJugador);
				} else if (quierecarta.equals("N") || quierecarta.equals("n")) {
					// Vuelve al principio con el mazo del juego y la mano del jugador. (Medida de
					// control para no perder los datos.)
					maquina();
				}
			}
		// Si el valor de la mano es 21, el jugador ganará. Y se le preguntará si quiere jugar de nuevo.
			if (manoJugador.valorMano() == 21) {
				System.out.println("¡Has ganado al crupier!");
				jugardenuevo();
			}
			// Si la mano hace que acabe el juego, perderá.
			if (manoJugador.findeJuego()) {
				System.out.println("Has perdido.");
				jugardenuevo();
			}	
		}
		
		
// FUNCIÓN jugardenuevo([sin parámetros]) - Se encarga de preguntar si el jugador quiere repetir el juego, empezando desde 0.
	protected static void jugardenuevo() {
		Scanner teclado = new Scanner(System.in);
			// Confirmación 2. ¿Volver a jugar?
			System.out.println("¿Quiere volver a jugar? - (S/N)");
			volverajugar = teclado.nextLine();
		// Si es verdadero:
		if (volverajugar.equals("S") || volverajugar.equals("s")) {
			// Vuelve al principio
			main(null);
		// Si es falso:
 		} else {
 			// Termina la ejecución.
			System.exit(0);
		}
	}
	
	//Función maquina([sin parámetros]) - Realiza la jugada completa de la máquina.
	protected static void maquina() {
		// Se genera una nueva mano.
		manoMaquina = new Mano();
		// Mientras el valor de la mano de la máquina sea
		// menor o igual al del jugador y el valor de la máquina sea menor o igual a 21, sigue jugando.
		while((manoMaquina.valorMano()<=manoJugador.valorMano()) && (manoMaquina.valorMano()<=21)) {
			// Continúa pidiendo cartas.
		manoMaquina.pedirCarta(mazoJuego);	
		}
		// Una vez terminado, se comprueba la puntuación.
		compruebapuntuacion();
	}
	protected static void compruebapuntuacion() {
		if((manoMaquina.valorMano()==21 && manoJugador.valorMano()==21) || ((manoMaquina.valorMano() > manoJugador.valorMano()) && (manoMaquina.valorMano()<=21))) {
			System.out.println(
					"La mano del jugador tiene " + manoJugador.valorMano() + " puntos.\nCartas:\n" + manoJugador.toString());
			System.out.println(
					"La mano de la máquina tiene " + manoMaquina.valorMano() + " puntos.\nCartas:\n" + manoMaquina.toString());
			System.out.println("Pierdes.");
			jugardenuevo();
		}else if(manoMaquina.valorMano()>21 || manoMaquina.valorMano()<manoJugador.valorMano()){
			System.out.println(
					"La mano del jugador tiene " + manoJugador.valorMano() + " puntos.\nCartas:\n" + manoJugador.toString());
			System.out.println(
					"La mano de la máquina tiene " + manoMaquina.valorMano() + " puntos.\nCartas:\n" + manoMaquina.toString());
			System.out.println("¡Has ganado!");
			jugardenuevo();
		}
	}
}