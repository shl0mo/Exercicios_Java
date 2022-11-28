package br.edu.icomp.ufam.lab_heranca;

public class Quadrado extends Retangulo {

	public Quadrado (int posX, int posY, double lado) {
		super(posX, posY, lado);
	}

	@Override
	public String toString () {
		return "Quadrado na posição (" + this.posX + ", " + this.posY + ") com lado de " + this.lado + "cm (área=" + (this.lado*this.lado) + "cm2, perímetro=" + (this.lado*4) + "cm)";
	}
}
