package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel {
	public CarroLuxuoso (String placa) {
		super(placa);
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
		return 15.0;
	}
}
