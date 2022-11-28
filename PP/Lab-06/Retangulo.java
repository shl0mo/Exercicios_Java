package br.edu.icomp.ufam.lab_heranca;

public class Retangulo extends FormaGeometrica {
	public double largura;
	public double altura;
	public double lado;

	public Retangulo (int posX, int posY, double largura, double altura) {
		super(posX, posY);
		this.largura = largura;
		this.altura = altura;
	}

	public Retangulo (int posX, int posY, double lado) {
		super(posX, posY);
		this.lado = lado;
		this.altura = lado;
		this.largura = lado;
	}
	
	@Override
	public double getArea () {
		return this.largura*this.altura;
	}
	
	@Override
	public double getPerimetro () {
		return 2*(this.largura + this.altura);
	}

	@Override
	public String toString () {
		return "Retângulo na posição (" + this.posX + ", " + this.posY + ") com largura de " + this.largura + "cm e altura de " + this.altura + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
	}
}
