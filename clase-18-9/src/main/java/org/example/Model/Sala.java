package org.example.Model;

import java.time.LocalTime;
import java.util.HashMap;
import org.example.Model.Pelicula;

public class Sala {
    private int id;
    private Pelicula pelicula;
    private HashMap<String, HashMap<Character,HashMap<Integer, Asiento>>> asientos_horario;

    public Sala(int id, Pelicula pelicula) {
        this.id = id;
        this.pelicula = pelicula;

        for (String horario : pelicula.getHorarios()) {
            HashMap<Character,HashMap<Integer, Asiento>> asientos = crear_asientos();
            asientos_horario = new HashMap<>();
            asientos_horario.put(horario, asientos);
        }
    }
    private HashMap<Character,HashMap<Integer, Asiento>> crear_asientos() {
        HashMap<Character,HashMap<Integer, Asiento>> asientos = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            char fila = numeroALetra(i);
            HashMap<Integer, Asiento> asientos_por_fila = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                Asiento asiento = new Asiento();
                asientos_por_fila.put(j, asiento);
            }
            asientos.put(fila, asientos_por_fila);
        }
        return asientos;
    }
    public char numeroALetra(int numero) {
        return (char) ('A' + numero);
    }
}


