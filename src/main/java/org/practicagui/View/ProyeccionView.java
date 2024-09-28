package org.practicagui.View;

import org.practicagui.Model.Proyeccion;

public class ProyeccionView {

    private Proyeccion proyeccion;

    public ProyeccionView(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public String mostrarProyeccion() {
        return String.format("Película: %s - Sala: %d - Horario: %s", proyeccion.getPelicula(), proyeccion.getSala(), proyeccion.getHorario());
    }

    @Override
    public String toString() {
        return mostrarProyeccion();
    }

    public int getIdProyeccion() {
        return proyeccion.getIdProyeccion();
    }
}
