package br.edu.ufam.icomp.lab_excecoes;

public class DistanciaEntrePontosExcedidaException extends RoverCaminhoException {
	private String msg;
	
	public DistanciaEntrePontosExcedidaException () {
		
	}
	
	public DistanciaEntrePontosExcedidaException (String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public String getMessage () {
		return "Distância máxima entre duas coordenadas vizinhas excedida";
	}
}
