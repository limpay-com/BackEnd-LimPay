package br.com.limpay.domain;

public class Coordenadas {
    private final double latitude;
    private final double longitude;

    public Coordenadas(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
