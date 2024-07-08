package com.alura.cieloscopio.model.currentweather;

import com.alura.cieloscopio.model.City;

public class Weather extends City {
    private String currentTemp;
    private String minTemp;
    private String maxTemp;
    private String climateCondition;
    private String Precipitation;

    public Weather(String longitude, String latitude, String name) {
        super(longitude, latitude, name);
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getClimateCondition() {
        return climateCondition;
    }

    public void setClimateCondition(String climateCondition) {
        this.climateCondition = climateCondition;
    }

    public String getPrecipitation() {
        return Precipitation;
    }

    public void setPrecipitation(String precipitation) {
        Precipitation = precipitation;
    }
}
