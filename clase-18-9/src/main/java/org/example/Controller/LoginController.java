package org.example.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;

    @FXML
    private TextField dni;

    @FXML
    private TextField email;

    @FXML
    private Button botonDatosIngresados;

    @FXML
    private void handleLoginButtonAction() throws IOException {
        // Verificar los campos
        String nombreText = nombre.getText();
        String apellidoText = apellido.getText();
        String dniText = dni.getText();
        String emailText = email.getText();

        if (nombreText.isEmpty() || apellidoText.isEmpty() || dniText.isEmpty() || emailText.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Campos vacíos");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor llene todos los campos");
            alerta.showAndWait();
        } else {
            // TODO Cargar la nueva escena pantalla de salas
        }
    }
}
