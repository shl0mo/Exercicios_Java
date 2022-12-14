package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {
	public static void main (String args[]) {
		try {
			Coordenada c1 = new Coordenada(1, 3, 4);
			Coordenada c2 = new Coordenada(4, 5, 4);
			Coordenada c3 = new Coordenada(10, 15, 10);
			Caminho c = new Caminho(3);
			c.addCoordenada(c1);
			c.addCoordenada(c2);
			c.addCoordenada(c3);
			c.toString();
		} catch (Exception RoverException) {
			System.out.println(RoverException.getMessage());
		}
	}
}
