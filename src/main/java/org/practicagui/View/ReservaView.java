package org.practicagui.View;

import org.practicagui.Model.Butaca;

public class ReservaView {

    private Butaca reserva;
    private PersonaView personaView;

    public ReservaView(Butaca reserva, PersonaView personaView) {
        this.reserva = reserva;
    }

    public String mostrarReserva() {
        return String.format("");
    }

    @Override
    public String toString() {
        return mostrarReserva();
    }
}
