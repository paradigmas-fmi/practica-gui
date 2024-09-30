package org.practicagui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.practicagui.Model.Persona.EmailValidator;
import org.practicagui.Model.Persona.IDValidator;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class LoginController extends SceneController {

    @FXML
    private TextField nombreBox;

    @FXML
    private TextField apellidoBox;

    @FXML
    private TextField dniBox;

    @FXML
    private TextField emailBox;

    @FXML
    private void handleLoginButtonAction(ActionEvent e) throws IOException {
        String nombreText = nombreBox.getText();
        String apellidoText = apellidoBox.getText();
        String dniText = dniBox.getText();
        String emailText = emailBox.getText();

        if (nombreText.isEmpty() || apellidoText.isEmpty() || dniText.isEmpty() || emailText.isEmpty()) {
            this.showAlert(AlertType.WARNING,"Campos vacíos", null,"Por favor rellene todos los campos");
        } else if (!IDValidator.validarDni(dniText)) {
            this.showAlert(AlertType.WARNING, "Formato de número inválido.", null, "Por favor ingrese un número entre 1000000 y 99999999 en el campo DNI.");
        } else if (!EmailValidator.validarEmail(emailText)) {
            this.showAlert(AlertType.WARNING, "Dirección de e-mail inválida.", null, "Por favor ingrese una dirección de e-mail válida. Ejemplo: johndoe@gmail.com");
        } else {
            int dniInt = Integer.parseInt(dniText);
            if (this.cineController != null) {
                this.cineController.crearPersona(nombreText, apellidoText, dniInt, emailText);
                this.switchScene(e, "/SeleccionPelicula.fxml");
            } else {
                this.showAlert(AlertType.WARNING, "Error", null, "cineController no está inicializado.");
            }
        }
    }

    @FXML
    public void handleEnterKeyPress(KeyEvent ke) throws IOException {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            handleLoginButtonAction(new ActionEvent(ke.getSource(), ke.getTarget()));
        }
    }
}