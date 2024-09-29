package org.practicagui.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cine {

    protected Map<Integer, Sala> salas;
    protected HashMap<Integer, Pelicula> peliculas;
    protected Map<Pelicula, Map<Integer, Proyeccion>> proyecciones;
    protected int counterProyecciones;

    public Cine() {
        this.salas = new HashMap<>();
        this.peliculas = new HashMap<>();
        this.proyecciones = new HashMap<>();
        this.counterProyecciones = 0;
    }

    public boolean addSala(int idSala, int filas, int butacasPorFila) {
        if ((salas.containsKey(idSala)) || (idSala < 0)) {
            return false;
        } else if ((filas < 0) || (butacasPorFila < 0)) {
            return false;
        }
        salas.put(idSala, new Sala(idSala, filas, butacasPorFila));
        return true;
    }

    public boolean addPelicula(Pelicula pelicula) {
        if (peliculas.containsKey(pelicula.getIdPelicula())) {
            return false;
        }
        peliculas.put(pelicula.getIdPelicula(), pelicula);
        proyecciones.put(pelicula, new HashMap<>());
        return true;
    }

    public boolean addProyeccion(Pelicula pelicula, int idSala, LocalDateTime horario) {
        if (!proyecciones.containsKey(pelicula)) {
            return false;
        } else if (!salas.containsKey(idSala)) {
            return false;
        }
        Sala sala = salas.get(idSala);
        Map<Integer, Proyeccion> proyecciones = this.proyecciones.get(pelicula);
        Proyeccion newProyeccion = new Proyeccion(pelicula, sala, horario, counterProyecciones);
        for (Proyeccion proyeccion : proyecciones.values()) {
            if (newProyeccion.equals(proyeccion)) {
                return false;
            }
            if (this.seSuperponen(newProyeccion, proyeccion)) {
                return false;
            }
        }
        this.proyecciones.get(pelicula).put(counterProyecciones, newProyeccion);
        counterProyecciones++;
        return true;
    }

    private boolean seSuperponen(Proyeccion p1, Proyeccion p2) {
        int duracionp1 = p1.getDuracion();
        int duracionp2 = p2.getDuracion();
        int salap1 = p1.getSala();
        int salap2 = p2.getSala();
        LocalDateTime horarioIniciop1 = p1.getHorario();
        LocalDateTime horarioIniciop2 = p2.getHorario();
        LocalDateTime horarioFinp1 = horarioIniciop1.plusMinutes(duracionp1);
        LocalDateTime horarioFinp2 = horarioIniciop2.plusMinutes(duracionp2);
        if (salap1 == salap2) {
            return !(horarioFinp1.isBefore(horarioIniciop2)) && !(horarioFinp2.isBefore(horarioIniciop1));
        }
        return false;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return new ArrayList<>(peliculas.values());
    }

    public Pelicula getPeliculaPorId(int idPelicula) {
        return this.peliculas.get(idPelicula);
    }

    public Proyeccion getProyeccionPorId(int idProyeccion, Pelicula pelicula) {
        Map<Integer, Proyeccion> proyecciones = this.proyecciones.get(pelicula);
        return proyecciones.get(idProyeccion);
    }

    public ArrayList<Proyeccion> getProyeccionesPelicula(Pelicula pelicula) {
        return new ArrayList<>(proyecciones.get(pelicula).values());
    }
}
