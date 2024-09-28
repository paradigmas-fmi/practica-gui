package org.practicagui.Model.Persona;

import static org.practicagui.Model.Persona.EmailValidator.validarEmail;

public class Persona {
    String nombre;
    String apellido;
    int dni;
    String email;

    public Persona(String nombre, String apellido, int dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDNI() {
        return dni;
    }

    public String getEmail() {
        return email;
    }
}


