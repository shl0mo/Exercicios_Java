package br.edu.ufam.icomp.lab_encapsulamento;

class GISMain {
	public static void main (String args[]) {
		Localizavel localizaveis[] = new Localizavel[2];
		Celular celular = new Celular(1, 2, 3);
		CarroLuxuoso carro_luxuoso = new CarroLuxuoso("Placa321");
		localizaveis[0] = celular;
		localizaveis[1] = carro_luxuoso;
		for (Localizavel l: localizaveis) {
			System.out.println(l.getPosicao());
		}
	}
}
