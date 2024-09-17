package org.example.Model;

public class Asiento {
    boolean estado;

    public Asiento() {
        this.estado = false;
    }

    public void ocupar() {
        this.estado = true;
    }

}

