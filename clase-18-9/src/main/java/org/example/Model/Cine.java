package org.example.Model;

import java.util.ArrayList;

public class Cine {
    String nombre;
    String[] peliculas = {"Deadpool & Wolverine", "Mi villano favorito 4", "Romper el circulo"};
    ArrayList<Sala> salas = new ArrayList<>();
    public Cine(String nombre) {
        this.nombre = nombre;
        for (int i = 0 ; i < 3; i++) {
            salas.add(new Sala(i, peliculas[i]));
        }
    }
}
