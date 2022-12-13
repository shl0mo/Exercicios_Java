package br.edu.ufam.icomp.lab_excecoes;

public class TamanhoMaximoExcedidoException extends RoverCaminhoException {
	private String msg;
	
	public TamanhoMaximoExcedidoException () {
		
	}
	
	public TamanhoMaximoExcedidoException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Quantidade máxima de coordenadas excedida";
	}
}
