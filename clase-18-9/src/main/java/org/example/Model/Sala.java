package org.example.Model;

import java.util.HashMap;

public class Sala {
    private int id;
    private String pelicula;
    private HashMap<Character,HashMap<Integer, Asiento>> asientos;

    public Sala(int id, String pelicula) {
        this.id = id;
        this.pelicula = pelicula;
        this.asientos = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            char fila = numeroALetra(i);
            HashMap<Integer, Asiento> asientos_por_fila = new HashMap<>();
            for (int j = 0; j < 20; j++) {
                Asiento asiento = new Asiento();
                asientos_por_fila.put(j, asiento);
            }
            asientos.put(fila, asientos_por_fila);
        }
    }

    public char numeroALetra(int numero) {
        return (char) ('A' + numero);
    }
}


