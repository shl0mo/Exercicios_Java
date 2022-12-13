package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaForaDosLimitesException extends RoverCoordenadaException {
	private String msg;
	
	public CoordenadaForaDosLimitesException () {
		
	}
	
	public CoordenadaForaDosLimitesException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Coordenada com valores fora dos limites";
	}
}
