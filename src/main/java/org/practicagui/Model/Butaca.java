package org.practicagui.Model;

import org.practicagui.Model.Persona.Persona;

public class Butaca {

    protected boolean disponible;

    protected int fila;

    protected int numero;

    protected Persona ocupante;

    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.disponible = true;
    }

    public boolean reservar(Persona persona) {
        if (!disponible) return false;
        this.disponible = false;
        this.ocupante = persona;
        return true;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }

    public Persona getOcupante() {
        return ocupante;
    }
}

