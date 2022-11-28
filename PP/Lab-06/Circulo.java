package br.edu.icomp.ufam.lab_heranca;

public class Circulo extends FormaGeometrica {
	public double raio;

	public Circulo (int posX, int posY, double raio) {
		super(posX, posY);
		this.raio = raio;
	}

	public double getArea () {
		return Math.PI*this.raio*this.raio;
	}

	public double getPerimetro () {
		return 2*Math.PI*this.raio;
	}

	public String toString () {
		return "Círculo na posição (" + this.posX + ", " + this.posY + ") com raio de " + this.raio + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
	}
}
