package org.practicagui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.practicagui.Model.Butaca;
import org.practicagui.View.ButacaView;
import org.practicagui.View.PersonaView;

import java.io.IOException;
import java.util.Optional;

public class SeleccionButacaController extends SceneController{


    @FXML
    private GridPane asientos;
    @FXML
    private ImageView pantalla;
    private ButacaView butacaView = new ButacaView();



    public void initialize() {
        for (var node : asientos.getChildren().stream().map(n -> (ImageView) n).toList()) {
            int columna = GridPane.getColumnIndex(node);
            int fila = GridPane.getRowIndex(node);
            Butaca butaca = this.cineController.getButaca(fila,columna);
            if (butaca.estaDisponible()) {
                node.setImage(this.butacaView.getAsientoDisponible());
            } else {
                node.setImage(this.butacaView.getAsientoOcupado());
            }
        }
    }

    public void handleMouseClicked(MouseEvent mouseEvent) {
        ImageView nodo = (ImageView) mouseEvent.getSource();
        int columna = GridPane.getColumnIndex(nodo);
        int fila = GridPane.getRowIndex(nodo);

        Butaca butaca = this.cineController.getButaca(fila,columna);
        if (butaca.estaDisponible()) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setHeaderText("¿Seguro que quieres reservar este asiento?");
            Optional<ButtonType> resultado = confirmationAlert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK){
                this.cineController.crearReserva(fila, columna);
                nodo.setImage(this.butacaView.getAsientoOcupado());
                Alert confirmedAlert = new Alert(Alert.AlertType.INFORMATION);
                confirmedAlert.setHeaderText("Reserva realizada");
                confirmedAlert.show();
            }
        } else {
            Alert ocupadoAlert = new Alert(Alert.AlertType.INFORMATION);
            PersonaView ocupante = new PersonaView(butaca.getOcupante().getNombre(), butaca.getOcupante().getApellido());
            ocupadoAlert.setHeaderText("Este asiento esta reservado por:\n " + ocupante.mostrarPersona());
            ocupadoAlert.show();
        }

    }

    public void handleLogoutButton(ActionEvent e) throws IOException {
        this.switchScene(e, "/InicioCine.fxml");
    }
}
