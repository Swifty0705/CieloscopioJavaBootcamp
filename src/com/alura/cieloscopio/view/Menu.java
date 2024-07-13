package com.alura.cieloscopio.view;

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
                Nuestras selecciones:
                3.Bogotá D.C
                4.Ciudad de Mexico
                5.Buenos aires
                6.Rio de janeiro
                7. Salir
                """;
        List<String> ciudades = new ArrayList<>();
        DataWeather dataWeather = new DataWeather();

        do {
            System.out.println(menuText);
            response = sc.nextInt();
            sc.nextLine();
            switch (response) {
                case 1:
                    System.out.println("Digite la ciudad:");
                    String ciudad = sc.nextLine();
                    try {
                        System.out.println(dataWeather.showData(ciudad));
                        ciudades.add(ciudad);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n\nDatos de la ciudad\nCiudad: No encontrada \n\nMotivo:\nSe uso un caracter incorrecto\n\n");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\n\nDatos de la ciudad\nCiudad: No encontrada \n\nMotivo:\nNo se encontró la información\n\n");
                    }
                    break;
                case 2:
                    System.out.println("Seleccione una ciudad del historial:");
                    for (int i = 0; i < ciudades.size(); i++) {
                        System.out.println((i + 1) + ". " + ciudades.get(i));
                    }
                    int eleccion = sc.nextInt();
                    try {
                        System.out.println(dataWeather.showData(ciudades.get(eleccion - 1)));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\nSeleccione una ciudad del historial de manera correcta\n\n");
                    }
                    break;
                case 3:
                    System.out.println(dataWeather.showData("Bogota"));
                    ciudades.add("Bogota");
                    break;
                case 4:
                    System.out.println(dataWeather.showData("Ciudad de mexico"));
                    ciudades.add("Ciudad de Mexico");
                    break;
                case 5:
                    System.out.println(dataWeather.showData("Buenos aires"));
                    ciudades.add("Buenos aires");
                    break;
                case 6:
                    System.out.println(dataWeather.showData("Rio de janeiro"));
                    ciudades.add("Rio de janeiro");
                    break;
                case 7:
                    System.out.println("Gracias por usar la aplicación");
                    break;
                default:
                    System.out.println("\nSeleccione una opción valida\n");
            }
        } while (response != 7);
    }

}
