package cdm1.SamuelAlonso;

/**
 * Esta clase crea el tablero y realiza las operaciones necesarias en él.
 * 
 * @author Samuel
 *
 */
public class Tablero {

	String[] tablero;
	
	public Tablero() {
		tablero = new String[] {"_", "_", "_", "_", "_", "_", "_", "_", "_"};		
	}
	/**
	 * Se dibuja el tablero.
	 */
	public void dibujarTablero() {
		System.out.println("\n    1   2   3");
		System.out.println("A | " + tablero[0] + " | " + tablero[1] + " | " + tablero[2] + " |");
		System.out.println();
		System.out.println("B | " + tablero[3] + " | " + tablero[4] + " | " + tablero[5] + " |");
		System.out.println();
		System.out.println("C | " + tablero[6] + " | " + tablero[7] + " | " + tablero[8] + " |");
	}
	
	/**
	 * Se comprueba si hay algún ganador.
	 * @return 
	 */
	public String compruebaGanador() {
		String ganador = null;
		for (int a = 0; a < 8; a++) {
			String linea = null;
			switch (a) {
			case 0:
				linea = tablero[0] + tablero[1] + tablero[2];
				break;
			case 1:
				linea = tablero[3] + tablero[4] + tablero[5];
				break;
			case 2:
				linea = tablero[6] + tablero[7] + tablero[8];
				break;
			case 3:
				linea = tablero[0] + tablero[3] + tablero[6];
				break;
			case 4:
				linea = tablero[1] + tablero[4] + tablero[7];
				break;
			case 5:
				linea = tablero[2] + tablero[5] + tablero[8];
				break;
			case 6:
				linea = tablero[0] + tablero[4] + tablero[8];
				break;
			case 7:
				linea = tablero[2] + tablero[4] + tablero[6];
				break;
			}
			if (linea.equals("XXX")) {
				ganador = "X";
			} else if (linea.equals("OOO")) {
				ganador = "O";
			}
		}
		return ganador;
	}
	
	/**
	 * Comprueba si el tablero está completo.
	 * @return
	 */
	public boolean completo() {
		boolean estaCompleto = false;
		if(tablero[0] != "_" && tablero[1] != "_" && tablero[2] != "_" && tablero[3] != "_" && tablero[4] != "_" && tablero[5] != "_" && tablero[6] != "_" && tablero[7] != "_" && tablero[8] != "_") {
			estaCompleto = true;
		}
		return estaCompleto;
	}
	
	/**
	 * Método para cambiar la casilla.
	 * @param linea
	 * @param jugador
	 * @return
	 */
	public boolean cambiarCasilla(String linea, Jugador jugador) {
		boolean cambiado = false;
		switch(linea) {
		case "A1":
			if(tablero[0] != "X" && tablero[0] != "O") {
				tablero[0] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "A2":
			if(tablero[1] != "X" && tablero[1] != "O") {
				tablero[1] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "A3":
			if(tablero[2] != "X" && tablero[2] != "O") {
				tablero[2] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "B1":
			if(tablero[3] != "X" && tablero[3] != "O") {
				tablero[3] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "B2":
			if(tablero[4] != "X" && tablero[4] != "O") {
				tablero[4] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "B3":
			if(tablero[5] != "X" && tablero[5] != "O") {
				tablero[5] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "C1":
			if(tablero[6] != "X" && tablero[6] != "O") {
				tablero[6] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "C2":
			if(tablero[7] != "X" && tablero[7] != "O") {
				tablero[7] = jugador.getFichas();
				cambiado = true;
			}
			break;
		case "C3":
			if(tablero[8] != "X" && tablero[8] != "O") {
				tablero[8] = jugador.getFichas();
				cambiado = true;
			}
			break;
		}
		return cambiado;	
	}
}
