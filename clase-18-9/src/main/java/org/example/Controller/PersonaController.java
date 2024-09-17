package org.example.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Model.Persona;

import java.io.IOException;

public class PersonaController {

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;

    @FXML
    private TextField dni;

    @FXML
    private TextField email;

    @FXML
    private Button DatosBoton;

    @FXML
    private Label errorMessage;

    @FXML
    private void handleLoginButtonAction() throws IOException {
        // Verificar los campos
        String nombreText = nombre.getText();
        String apellidoText = apellido.getText();
        String dniText = dni.getText();
        String emailText = email.getText();

        if (nombreText.isEmpty() || apellidoText.isEmpty() || dniText.isEmpty() || emailText.isEmpty()) {
            System.out.println("Todos los campos deben ser llenados.");
        } else {
            // TODO Cargar la nueva escena pantalla de salas
        }
    }
}
