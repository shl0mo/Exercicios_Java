package br.edu.icomp.ufam.lab_heranca;

class FormasMain {
	public static void main (String args[]) {
		FormaGeometrica vetor_formas[] = new FormaGeometrica[3];
		Circulo circulo = new Circulo(3, 3, 12);
		Retangulo retangulo = new Retangulo(6, 7, 6, 6);
		Quadrado quadrado = new Quadrado(1, 2, 5);
		for (int i = 0; i < vetor_formas.length; i++) {
			System.out.println(vetor_formas[i]);
		}
	}
}
