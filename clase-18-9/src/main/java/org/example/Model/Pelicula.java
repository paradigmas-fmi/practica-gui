package org.example.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {

    private String titulo;
    private String director;
    private String sinopsis;
    private List<LocalTime> horarios;

    public Pelicula(String titulo, String director, String sinopsis, List<LocalTime> horarios) {
        this.titulo = titulo;
        this.director = director;
        this.sinopsis = sinopsis;
        this.horarios = horarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public List<String> getHorarios() {
        List<String> horariosString = new ArrayList<>();
        for (LocalTime horario : horarios) {
            horariosString.add(horario.toString());
        }
        return horariosString;
    }
}
