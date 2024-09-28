package org.practicagui.Model;

public class Sala {

    protected int id;
    protected int filas;
    protected int butacasPorFila;

    public Sala(int id, int filas, int butacasPorFila) {
        this.id = id;
        this.filas = filas;
        this.butacasPorFila = butacasPorFila;
    }

    public int getId() {
        return id;
    }

    public int getFilas() {
        return filas;
    }

    public int getButacasPorFila() {
        return butacasPorFila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        if (sala.getFilas() != sala.filas) return false;
        if (sala.getId() != sala.id) return false;
        return sala.getButacasPorFila() == sala.butacasPorFila;
    }
}


