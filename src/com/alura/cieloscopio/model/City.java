package com.alura.cieloscopio.model;

public class City {
    private String name;
    private String latitude;
    private String longitude;

    public City(String longitude, String latitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }
}
