package org.practicagui.View;

public class PersonaView {

    String nombre;
    String apellido;
    public PersonaView(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String mostrarPersona() {
        return String.format(
                "Nombre: %s\n" +
                "Apellido: %s\n"
                , this.nombre, this.apellido);
    }

    @Override
    public String toString() {
        return mostrarPersona();
    }

}
