package cdm1.SamuelAlonso;

public class ExcepcionCoordenada extends Exception{
	
	private int malIndicada = 0;
	static final int MAL_TAMANIO = -1;
	static final int MAL_COOR = -2;

	public ExcepcionCoordenada() {
		super();
	}
	
	public ExcepcionCoordenada(String s) {
		super(s);
	}
	
	public ExcepcionCoordenada(int error) {
		this.malIndicada = error;
	}
	
	public int getMalIndicada() {
		return this.malIndicada;
	}
	
	public void setMalIndicada(int error) {
		this.malIndicada = error;
	}
	
}