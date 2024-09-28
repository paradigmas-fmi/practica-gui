package org.practicagui.Model;

public class Pelicula {

    private int idPelicula;
    private String titulo;
    private String director;
    private int duracionEnMinutos;
    private String pathImagenAsociada;

    public Pelicula(String titulo, String director, int duracionEnMinutos, String pathImagenAsociada, int idPelicula) {
        this.titulo = titulo;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.pathImagenAsociada = pathImagenAsociada;
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getPathImagenAsociada() {
        return pathImagenAsociada;
    }
}