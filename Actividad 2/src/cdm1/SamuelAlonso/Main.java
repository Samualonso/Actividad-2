package cdm1.SamuelAlonso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Esta es la clase Main en la cual se realiza el juego.
 * 
 * @author Samuel Alonso
 *
 */

public class Main {

	public static void main(String[] args) {
		
		String fecha = new SimpleDateFormat("dd-MM-yyyy-HHmmss").format(new Date());
		String fileName = fecha.concat("-log.txt");
		FileWriter fichero;
		PrintWriter pw;
		ArrayList<String> movimientos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		boolean acabado = false;
		Jugador jugador1 = new Jugador("Jugador 1", 0, "X");
		Jugador jugador2 = new Jugador("Jugador 2", 0, "O");
		Jugador jugadorActual = new Jugador("Jugador Actual", 0, "X");
		Tablero tablero = new Tablero();
		String casilla = "";
		ValidarCoordenada validacion = new ValidarCoordenada();
		
		do {
			System.out.println("¡Bienvenido al juego del tres en raya!");
			System.out.println("======================================\n");
			/**
			 * Se introduce el nombre de los jugadores y se guarda la fecha de creacion en el array de movimientos.
			 */
			System.out.println("Introduce el nombre del jugador 1.");
			jugador1.setNombre(sc.nextLine());
			fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			movimientos.add(fecha + " Se ha introducido el nombre del jugador 1. " + jugador1.getNombre());
			System.out.println("Introduce el nombre del jugador 2.");
			jugador2.setNombre(sc.nextLine());
			fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			movimientos.add("\n" + fecha + " Se ha introducido el nombre del jugador 2. " + jugador2.getNombre());
			movimientos.add("\n" + fecha + " Van a jugar " + jugador1.getNombre() + " y " + jugador2.getNombre());
			
			/**
			 * Se tiran los dados de los dos jugadores.
			 */
			while(jugador1.getDado() == jugador2.getDado()) {
				
				System.out.println("\nDado para " + jugador1.getNombre());
				jugador1.setDado((int) (Math.random()*6+1));
				System.out.println(jugador1.getDado());
				fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
				movimientos.add("\n" + fecha + " " + jugador1.getNombre() + " ha tirado dado y ha sacado un " + jugador1.getDado());
				
				System.out.println("Dado para " + jugador2.getNombre());
				jugador2.setDado((int) (Math.random()*6+1));
				System.out.println(jugador2.getDado());
				fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
				movimientos.add("\n" + fecha + " " + jugador2.getNombre() + " ha tirado dado y ha sacado un " + jugador2.getDado());
				
				/**
				 * Se cambian los jugadores si el dado del segundo jugador es mayor.
				 */
				if(jugador2.getDado() > jugador1.getDado()) {
					
					String cambio = jugador1.getNombre();
					jugador1.setNombre(jugador2.getNombre());
					jugador2.setNombre(cambio);
					fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
					movimientos.add("\n" + fecha + " " + jugador1.getNombre() +" jugará primero");
					
				}
			}
			System.out.println("\n" + jugador1.getNombre() + " empieza primero.");
			
			tablero.dibujarTablero();
			jugadorActual = jugador1;
			
			do {
				
				try {
					
					boolean noCambiada = true;
					while(noCambiada) {
						/**
						 * Se introduce las coordenadas y se comprueba que es válida.
						 */
						System.out.println();
						fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
						movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " va a introducir coordenadas");
						System.out.println(jugadorActual.getNombre() + " introduce las coordenadas");
						casilla = sc.nextLine().toUpperCase();
						validacion.validar(casilla);
						
						if(tablero.cambiarCasilla(casilla, jugadorActual)) {
							fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
							movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " ha elegido " + casilla);
							tablero.dibujarTablero();
							noCambiada = false;
						}else {
							System.out.println("Casilla ocupada");
							fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
							movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " ha introducido una coordenada ya ocupada");
						}
					}
					
					String ganador = tablero.compruebaGanador();
					/**
					 * Se comprueba si hay algún ganador y si el tablero está completo
					 */
					if(ganador == "X" || ganador == "O") {
						acabado = true;
						jugadorActual.setGanador(true);
						fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
						movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " ha ganado la partida");
					}else if (tablero.completo()) {
						acabado = true;
						System.out.println("\nHa habido un empate");
						fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
						movimientos.add("\n" + fecha + " La partida ha quedado empate");
					}
					
					/**
					 * Se cambia el turno.
					 */
					if(jugadorActual == jugador1) {
						jugadorActual = jugador2;
					}else if(jugadorActual == jugador2) {
						jugadorActual = jugador1;
					}
					
				}catch(ExcepcionCoordenada e) {
					switch(e.getMalIndicada()) {
					case ExcepcionCoordenada.MAL_TAMANIO:
						System.out.println("El tamaño de la coordenada indicada no es correcto");
						fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
						movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " ha introducido mal las coordenadas");
						break;
					case ExcepcionCoordenada.MAL_COOR:
						System.out.println("La coordenada indicada no está dentro del limite del tablero");
						fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
						movimientos.add("\n" + fecha + " " + jugadorActual.getNombre() + " ha introducido mal las coordenadas");
						break;
					}
				}
				
			}while(!acabado);
			
			if(jugador1.esGanador()) {
				System.out.println("\nEnhorabuena, " + jugador1.getNombre() + " has ganado la partida");
			}else if(jugador2.esGanador()) {
				System.out.println("\nEnhorabuena, " + jugador2.getNombre() + " has ganado la partida");
			}
			
			try {
				fichero = new FileWriter(fileName);
				pw = new PrintWriter(fichero);
				for(int i = 0; i < movimientos.size(); i++) {
					pw.println(movimientos.get(i));
				}
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!acabado);
	}
}
