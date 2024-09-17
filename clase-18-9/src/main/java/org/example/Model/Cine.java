package org.example.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Cine {
    String nombre;

    Pelicula peliculaSala1 = new Pelicula("Mi villano favorito 4", "Chris Renaud","Gru se enfrenta a nuevos némesis, Maxime Le Mal (Will Ferrell, ganador del Emmy) y su novia Valentina (Sofía Vergara, nominada al Emmy), por lo cual la familia se ve obligada a huir.", new ArrayList<>());
    ArrayList<Sala> salas = new ArrayList<>();
    public Cine(String nombre) {
        this.nombre = nombre;
        for (int i = 0 ; i < 3; i++) {
            salas.add(new Sala(i, peliculaSala1));
        }
    }
}
