package br.edu.ufam.icomp.lab_excecoes;

public class RoverCoordenadaException extends RoverException{ 
	private String msg;
	
	public RoverCoordenadaException () {
		
	}
	
	public RoverCoordenadaException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Exceção geral de coordenada do rover";
	}
}
