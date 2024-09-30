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
        this.idProyeccion = idProyeccion;
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

    public boolean realizarReserva(Persona persona, int fila, int columna) {
        if (fila < 0 || columna < 0) {
            return false;
        }
        Butaca butacaAReservar = this.reservas[fila][columna];
        if (!butacaAReservar.estaDisponible()) {
            return false;
        }
        butacaAReservar.reservar(persona);
        return true;
    }


    public String getPelicula() {
        return pelicula.getTitulo();
    }

    public int getDuracion() {
        return pelicula.getDuracionEnMinutos();
    }

    public Sala getSala() {
        return sala;
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
            return (Objects.equals(p.getPelicula(), this.pelicula.getTitulo())) && (p.getHorario() == this.horario) && (p.getSala().getId() == sala.getId());
        }
        return false;
    }

    public Butaca getButaca(int fila, int columna) {
        return this.reservas[fila][columna];
    }
}