package br.edu.ufam.icomp.lab_excecoes;

public class RoverException extends Exception{ 
	private String msg;
	
	public RoverException () {
		
	}
	
	public RoverException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Exceção geral do rover";
	}
}
