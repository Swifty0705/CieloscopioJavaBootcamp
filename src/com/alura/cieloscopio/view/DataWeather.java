package com.alura.cieloscopio.view;

import com.alura.cieloscopio.controller.ApiController;
import com.alura.cieloscopio.model.currentweather.WeatherOpenWeather;
import com.alura.cieloscopio.model.geocoding.GeoOpenWeather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataWeather {
    public String showData(String city) throws IOException, InterruptedException {
        ApiController controller = new ApiController();
        GeoOpenWeather geoOpenWeather;
        String ciudad;
        Double currentTemp;
        Double minTemp;
        Double maxTemp;
        int humidity;

        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setTimeZone(TimeZone.getDefault());
        String fecha = formatoFecha.format(fechaActual);
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("hh:mm a");
        formatoFechaHora.setTimeZone(TimeZone.getDefault());
        String hora = formatoFechaHora.format(fechaActual);

        geoOpenWeather = controller.conectarApiGeo(city);
        WeatherOpenWeather weatherOpenWeather = controller.conectarApiWeather(geoOpenWeather.lon(), geoOpenWeather.lat());
        ciudad = geoOpenWeather.name();
        currentTemp = weatherOpenWeather.main().temp();
        minTemp = weatherOpenWeather.main().temp_min();
        maxTemp = weatherOpenWeather.main().temp_max();
        humidity = weatherOpenWeather.main().humidity();

        String data = "\n\nDatos de la ciudad\nCiudad: " + ciudad + "\nFecha: " + fecha + "\nHora: " + hora +
                "\n\nDatos Meteorologicos\nTemperatura actual: " + currentTemp + " °C\nTemperatura minima: " + minTemp + " °C\nTemperatura maxima: " + maxTemp + " °C\nHumedad: " + humidity +
                "\n\n";
        return data;


    }
}
