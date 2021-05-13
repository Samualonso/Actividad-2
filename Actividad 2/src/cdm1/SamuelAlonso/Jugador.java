package cdm1.SamuelAlonso;

public class Jugador {

	private String jugador;
	private int dado;
	private String fichas;
	private boolean ganador;
	
	public Jugador(String jugador, int dado, String fichas) {
		this.jugador = jugador;
		this.dado = dado;
		this.fichas = fichas;
	}
	
	public boolean esGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public String getFichas() {
		return fichas;
	}
	
	public void setFichar(String fichas) {
		this.fichas = fichas;
	}

	public int getDado() {
		return dado;
	}
	
	public void setDado(int dado) {
		this.dado = dado;
	}
	
	public String getNombre() {
		return jugador;
	}

	public void setNombre(String jugador) {
		this.jugador = jugador;
	}
	
}
