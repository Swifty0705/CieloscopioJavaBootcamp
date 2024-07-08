package com.alura.cieloscopio.view;

import com.alura.cieloscopio.controller.ApiController;
import com.alura.cieloscopio.model.geocoding.GeoOpenWeather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void showMainMenu() throws IOException, InterruptedException {
        int response = 0;
        Scanner sc = new Scanner(System.in);
        String menuText = """
                Seleccione una de las opciones:
                1. Consultar la ciudad
                2. Ver historial
                3. Salir
                """;
        List<String> ciudades = new ArrayList<>();
        ApiController controller = new ApiController();
        GeoOpenWeather geoOpenWeather;

        do {
            System.out.println(menuText);
            response = sc.nextInt();
            switch (response) {
                case 1:
                    System.out.println("Digite la ciudad:");
                    String ciudad = sc.next();
                    ciudades.add(ciudad);

                    geoOpenWeather= controller.conectarApiGeo(ciudad);
                    System.out.println(controller.conectarApiWeather(geoOpenWeather.lon(), geoOpenWeather.lat()));
                    break;
                case 2:
                    System.out.println("Seleccione una ciudad del historial:");
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.println((i+1)+". "+ciudades.get(i));
                    }
                    int eleccion = sc.nextInt();
                    geoOpenWeather= controller.conectarApiGeo(ciudades.get(eleccion-1));
                    System.out.println(controller.conectarApiWeather(geoOpenWeather.lon(), geoOpenWeather.lat()));
                    break;
                case 3:
                    System.out.println("Gracias por usar la aplicación");
                    break;
                default:
                    System.out.println("Seleccione una opción valida");
            }
        }while(response != 0);
    }

}
