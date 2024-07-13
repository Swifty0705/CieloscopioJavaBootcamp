package com.alura.cieloscopio.controller;

import com.alura.cieloscopio.model.currentweather.WeatherOpenWeather;
import com.alura.cieloscopio.model.geocoding.GeoOpenWeather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiController {
    String keyID = "2e426faad012ae9e555def6ed9259a9b";
    String link;

    public GeoOpenWeather conectarApiGeo(String ciudad) throws IOException, InterruptedException {
        link = "http://api.openweathermap.org/geo/1.0/direct?q=" + ciudad + "&limit=1&appid=" + keyID;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

            GeoOpenWeather[] cities = gson.fromJson(Conection(link), GeoOpenWeather[].class);
            GeoOpenWeather miCity = cities[0];
            return miCity;
    }

    public WeatherOpenWeather conectarApiWeather(double lon, double lat) throws IOException, InterruptedException {
        link = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + keyID+"&units=metric&lang=es";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        WeatherOpenWeather myWeather = gson.fromJson(Conection(link), WeatherOpenWeather.class);
        
        return myWeather;
    }

    public static String Conection(String link) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
