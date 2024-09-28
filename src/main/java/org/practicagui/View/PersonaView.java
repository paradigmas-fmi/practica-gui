package org.practicagui.View;

import org.practicagui.Model.Persona.Persona;

public class PersonaView {

    private Persona persona;

    public PersonaView(Persona persona) {
        this.persona = persona;
    }

    public String mostrarPersona() {
        return String.format("Datos de la persona:\n" +
                "Nombre: %s\n" +
                "Apellido: %s\n" +
                "DNI: &s\n", persona.getNombre(), persona.getApellido(), persona.getDNI());
    }

    @Override
    public String toString() {
        return mostrarPersona();
    }

}
