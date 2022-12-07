package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class Celular implements Localizavel {
	private int codPais;
	private int codArea;
	private int numero;

	public Celular (int codPais, int codArea, int numero) {
		setCodPais(codPais);
		setCodArea(codArea);
		setNumero(numero);
	}

	public final void setCodPais (int codPais) {
		if (codPais >= 1 && codPais <= 1999) this.codPais = codPais;
		else this.codPais = -1;
	}

	public final void setCodArea (int codArea) {
		if (codArea >= 10 && codArea <= 99) this.codArea = codArea;
		else this.codArea = -1;
	}

	public final void setNumero (int numero) {
		if (numero >= 10000000 && numero <= 999999999) this.numero = numero;
		else this.numero = -1;
	}

	public int getCodPais () {
		return this.codPais;
	}

	public int getCodArea () {
		return this.codArea;
	}

	public int getNumero () {
		return this.numero;
	}

	public Posicao getPosicao () {
		double valor_minimo_latitude = -3.16;
		double valor_maximo_latitude = -2.96;
		double valor_minimo_longitude = -60.12;
		double valor_maximo_longitude = -59.82;
		double valor_minimo_altitude = 15;
		double valor_maximo_altitude = 100;
		Random r = new Random();
		double latitude = valor_minimo_latitude + (valor_maximo_latitude - valor_minimo_latitude) * r.nextDouble();
		double longitude = valor_minimo_longitude + (valor_maximo_longitude - valor_minimo_longitude) * r.nextDouble();
		double altitude = valor_minimo_altitude + (valor_maximo_altitude - valor_minimo_altitude) * r.nextDouble();
		return new Posicao(latitude, longitude, altitude);
	}

	public double getErroLocalizacao () {
		return 50.0;
	}
}
