package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaNegativaException extends RoverCoordenadaException {
	private String msg;
	
	public CoordenadaNegativaException () {
		
	}
	
	public CoordenadaNegativaException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Coordenada com valor negativo";
	}
}
