package org.practicagui.View;

import org.practicagui.Model.Cine;
import org.practicagui.Model.Pelicula;
import org.practicagui.Model.Proyeccion;
import org.practicagui.Model.Sala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CineView {

    protected Map<Pelicula, PeliculaView> peliculas;
    protected Map<Pelicula, ArrayList<ProyeccionView>> proyecciones;

    public CineView(Cine cine) {
        this.peliculas = new HashMap<>();
        this.proyecciones = new HashMap<>();
        ArrayList<Pelicula> peliculas = cine.getPeliculas();
        for (Pelicula pelicula : peliculas) {
            PeliculaView peliculaView = new PeliculaView(pelicula);
            this.peliculas.put(pelicula, peliculaView);
            this.proyecciones.put(pelicula, new ArrayList<>());
            ArrayList<Proyeccion> proyeccionesPelicula = cine.getProyeccionesPelicula(pelicula);
            for (Proyeccion p : proyeccionesPelicula) {
                this.proyecciones.get(pelicula).add(new ProyeccionView(p));
            }
        }
    }

    public PeliculaView getPeliculaView(Pelicula pelicula) {
        return this.peliculas.get(pelicula);
    }

    public ArrayList<ProyeccionView> getProyeccionesViewPelicula(Pelicula pelicula) {
        return this.proyecciones.get(pelicula);
    }
}