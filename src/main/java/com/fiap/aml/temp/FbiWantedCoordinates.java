package com.fiap.aml.temp;

public class FbiWantedCoordinates {
    private double lng;
    private double lat;
    private String formatted;

    public FbiWantedCoordinates() {

    }

    public FbiWantedCoordinates(double lng, double lat, String formatted) {
        this.lng = lng;
        this.lat = lat;
        this.formatted = formatted;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}