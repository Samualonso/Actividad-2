package cdm1.SamuelAlonso;

public class ValidarCoordenada {
	
	private boolean esBien(String m) {
		return m.substring(0, 2).matches("[A-C]{1}[1-3]{1}");
	}

	public void validar(String coordenada) throws ExcepcionCoordenada{
		if(coordenada.length() != 2) {
			throw new ExcepcionCoordenada(ExcepcionCoordenada.MAL_TAMANIO);
		} else {
			if(!esBien(coordenada)) {
				throw new ExcepcionCoordenada(ExcepcionCoordenada.MAL_COOR);
			}
		}
	}
}
