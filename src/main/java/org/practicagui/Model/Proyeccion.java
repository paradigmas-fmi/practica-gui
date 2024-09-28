package org.practicagui.Model;

import org.practicagui.Model.Persona.Persona;

import java.time.LocalDateTime;
import java.util.Objects;

public class Proyeccion {

    protected int idProyeccion;
    protected Pelicula pelicula;
    protected Sala sala;
    protected LocalDateTime horario;
    protected Butaca[][] reservas;

    public Proyeccion(Pelicula pelicula, Sala sala, LocalDateTime horario, int idProyeccion) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
        this.reservas = this.crearButacas();
    }

    private Butaca[][] crearButacas() {
        int filas = sala.getFilas();
        int butacasPorFila = sala.getButacasPorFila();
        Butaca[][] reservas = new Butaca[filas][butacasPorFila];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < butacasPorFila; j++) {
                reservas[i][j] = new Butaca(i, j);
            }
        }
        return reservas;
    }

    public boolean realizarReserva(Persona persona, int fila, int butaca) {
        if (fila < 0 || butaca < 0) {
            return false;
        }
        Butaca butacaAReservar = this.reservas[fila-1][butaca-1];
        if (!butacaAReservar.estaDisponible()) {
            return false;
        }
        butacaAReservar.reservar(persona);
        return true;
    }

    public int getCantidadDisponibles() {
        int cantidadDisponibles = 0;
        for (Butaca[] butacas : this.reservas) {
            for (Butaca butaca : butacas) {
                if (butaca.estaDisponible()) {
                    cantidadDisponibles++;
                }
            }
        }
        return cantidadDisponibles;
    }

    public String getPelicula() {
        return pelicula.getTitulo();
    }

    public int getDuracion() {
        return pelicula.getDuracionEnMinutos();
    }

    public int getSala() {
        return sala.getId();
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public int getIdProyeccion() {
        return this.idProyeccion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o instanceof Proyeccion)) {
            Proyeccion p = (Proyeccion) o;
            return (Objects.equals(p.getPelicula(), this.pelicula.getTitulo())) && (p.getHorario() == this.horario) && (p.getSala() == sala.getId());
        }
        return false;
    }
}