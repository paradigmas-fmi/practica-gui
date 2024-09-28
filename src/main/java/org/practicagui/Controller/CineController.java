package org.practicagui.Controller;

import org.practicagui.Model.Cine;
import org.practicagui.Model.Pelicula;
import org.practicagui.Model.Persona.Persona;

import org.practicagui.Model.Proyeccion;
import org.practicagui.View.CineView;
import org.practicagui.View.PeliculaView;
import org.practicagui.View.ProyeccionView;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CineController { // Removed static

    private static CineController instance; // Changed to private static
    private Cine cine; // Changed to private
    private CineView cineView; // Changed to private
    private Persona usuarioActual;
    private Pelicula peliculaSeleccionada;
    private Proyeccion proyeccionSeleccionada;

    private CineController() {
        this.cine = new Cine();
        cine.addSala(1, 15, 8);
        cine.addSala(2, 16, 8);
        cine.addSala(3, 16, 8);
        Pelicula miVillanoFavorito4 = new Pelicula("Mi villano favorito 4", "Chris Renaud", 94, "despicable-me.png", 1);
        Pelicula theSocialNetwork = new Pelicula("The Social Network", "David Fincher", 120, "social-network.png", 2);
        Pelicula starWarsEpisodioIII = new Pelicula("Star wars: episodio III - la venganza de los sith", "George Lucas", 140, "starwars-episode3.png", 3);
        Pelicula chinaTown = new Pelicula("China Town", "Roman Polanski", 131, "chinatown.png", 4);
        cine.addPelicula(theSocialNetwork);
        cine.addPelicula(miVillanoFavorito4);
        cine.addPelicula(starWarsEpisodioIII);
        cine.addPelicula(chinaTown);
        cine.addProyeccion(miVillanoFavorito4, 1, LocalDateTime.of(2024, 9, 18, 18, 0));
        cine.addProyeccion(theSocialNetwork, 2, LocalDateTime.of(2024, 9, 18, 21, 0));
        cine.addProyeccion(starWarsEpisodioIII, 3, LocalDateTime.of(2024, 9, 18, 19, 0));
        cine.addProyeccion(chinaTown, 3, LocalDateTime.of(2024, 9, 18, 22, 30));
        cine.addProyeccion(miVillanoFavorito4, 1, LocalDateTime.of(2024, 9, 19, 17, 0));
        this.cineView = new CineView(cine);
    }

    public static CineController getInstance() {
        if (instance == null) {
            instance = new CineController();
        }
        return instance;
    }

    public ArrayList<PeliculaView> getPeliculasView() {
        ArrayList<Pelicula> peliculas = cine.getPeliculas();
        ArrayList<PeliculaView> peliculaViews = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            peliculaViews.add(cineView.getPeliculaView(pelicula));
        }
        return peliculaViews;
    }

    public ArrayList<ProyeccionView> getProyeccionesViewPelicula(Pelicula pelicula) {
        return cineView.getProyeccionesViewPelicula(pelicula);
    }

    public void crearPersona(String nombre, String apellido, int DNI, String email) {
        this.usuarioActual = new Persona(nombre, apellido, DNI, email);
    }

    public void seleccionarPelicula(PeliculaView peliculaView) {
        int idPeliculaSeleccionada = peliculaView.getIdPelicula();
        this.peliculaSeleccionada = cine.getPeliculaPorId(idPeliculaSeleccionada);
    }

    public Pelicula getPeliculaSeleccionada() {
        return peliculaSeleccionada;
    }

    public void seleccionarProyeccion(ProyeccionView proyeccionView) {
        int idProyeccionSeleccionada = proyeccionView.getIdProyeccion();
        this.proyeccionSeleccionada = cine.getProyeccionPorId(idProyeccionSeleccionada);
    }

    public Proyeccion getProyeccionSeleccionada() {
        return proyeccionSeleccionada;
    }

//    public boolean crearReserva(Proyeccion) {
//
//    }
}