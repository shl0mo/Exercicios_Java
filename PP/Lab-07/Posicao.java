package br.edu.ufam.icomp.lab_encapsulamento;

public class Posicao {
	private double latitude;
	private double longitude;
	private double altitude;

	public Posicao (double latitude, double longitude, double altitude) {
		setLatitude(latitude);
		setLongitude(longitude);
		setAltitude(altitude);
	}

	public void setLatitude (double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude (double longitude) {
		this.longitude = longitude;
	}

	public void setAltitude (double altitude) {
		this.altitude = altitude;
	}

	public double getLatitude () {
		return this.latitude;
	}

	public double getLongitude () {
		return this.longitude;
	}

	public double getAltitude () {
		return this.altitude;
	}

	public String toString () {
		return "Posição: " + getLatitude() + ", "  + getLongitude() + ", " + getAltitude();
	}
}
