package br.edu.ufam.icomp.lab_excecoes;

public class RoverCaminhoException extends RoverException{ 
	private String msg;
	
	public RoverCaminhoException () {
		
	}
	
	public RoverCaminhoException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Exceção geral de caminho do rover";
	}
}
