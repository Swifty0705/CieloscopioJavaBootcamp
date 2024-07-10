package com.alura.cieloscopio.model.currentweather;

public record WeatherOpenWeather(CoordinatesData coord,String base, MainData main,int visibility, WindData wind,CloudsData clouds,int dt, SystemData sys, int timezone) {
}
