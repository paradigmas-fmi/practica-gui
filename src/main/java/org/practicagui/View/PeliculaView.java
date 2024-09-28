package org.practicagui.View;

import org.practicagui.Model.Pelicula;

public class PeliculaView {

    private Pelicula pelicula;

    public PeliculaView(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String mostrarPelicula() {
        return String.format("%s - Director: %s - Duración: %d minutos.", pelicula.getTitulo(), pelicula.getDirector(), pelicula.getDuracionEnMinutos());
    }

    @Override
    public String toString() {
        return mostrarPelicula();
    }

    public int getIdPelicula() {
        return pelicula.getIdPelicula();
    }

    public String getPathImagenAsociada() {
        return pelicula.getPathImagenAsociada();
    }
}
