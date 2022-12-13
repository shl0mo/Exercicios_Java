package br.edu.ufam.icomp.lab_excecoes;

public class DigitoInvalidoException extends RoverCoordenadaException {
	private String msg;
	
	public DigitoInvalidoException () {
		
	}
	
	public DigitoInvalidoException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Digito da coordenada inválido";
	}
}
