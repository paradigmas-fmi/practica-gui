package org.practicagui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.practicagui.Model.Butaca;
import org.practicagui.View.ButacaView;
import org.practicagui.View.PersonaView;

import java.io.IOException;
import java.util.Optional;

public class SeleccionButacaController extends SceneController {

    @FXML
    public Button backButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView pantalla;
    private ButacaView butacaView = new ButacaView();

    public void initialize() {
        GridPane asientos = new GridPane();
        asientos.setPrefSize(400, 400); // Set fixed size
        asientos.setMaxSize(400, 400);
        asientos.setMinSize(400, 400);

        int rows = this.cineController.getProyeccionSeleccionada().getSala().getFilas();
        int columns = this.cineController.getProyeccionSeleccionada().getSala().getButacasPorFila();

        double cellWidth = 400.0 / columns;
        double cellHeight = 400.0 / rows;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                ImageView seatImage = new ImageView();
                Butaca butaca = cineController.getButaca(row, col);
                if (butaca.estaDisponible()) {
                    seatImage.setImage(butacaView.getAsientoDisponible());
                } else {
                    seatImage.setImage(butacaView.getAsientoOcupado());
                }
                seatImage.setFitWidth(cellWidth);
                seatImage.setFitHeight(cellHeight);
                seatImage.setPreserveRatio(true);
                seatImage.setOnMouseClicked(this::handleMouseClicked);
                asientos.add(seatImage, col, row);
            }
        }

        anchorPane.getChildren().add(asientos);
        AnchorPane.setTopAnchor(asientos, 50.0);
        AnchorPane.setBottomAnchor(asientos, 50.0);
        AnchorPane.setLeftAnchor(asientos, 50.0);
        AnchorPane.setRightAnchor(asientos, 50.0);
        asientos.setAlignment(Pos.CENTER);
    }


    public void handleMouseClicked(MouseEvent mouseEvent) {
        ImageView nodo = (ImageView) mouseEvent.getSource();
        int columna = GridPane.getColumnIndex(nodo);
        int fila = GridPane.getRowIndex(nodo);

        Butaca butaca = this.cineController.getButaca(fila,columna);
        if (butaca.estaDisponible()) {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmación");
            confirmationAlert.setHeaderText("¿Seguro que quieres reservar este asiento?");
            Optional<ButtonType> resultado = confirmationAlert.showAndWait();

            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                this.cineController.crearReserva(fila, columna);
                nodo.setImage(this.butacaView.getAsientoOcupado());
                this.showAlert(AlertType.CONFIRMATION, "Confirmación", "Reserva realizada.", null);
            }
        } else {
            PersonaView ocupante = new PersonaView(butaca.getOcupante().getNombre(), butaca.getOcupante().getApellido());
            String mensajeReserva = "Este asiento esta reservado por:\n" + ocupante.mostrarPersona();
            this.showAlert(AlertType.INFORMATION, "Información de reserva", mensajeReserva, null);
        }
    }

    public void handleLogoutButton(ActionEvent e) throws IOException {
        this.switchScene(e, "/InicioCine.fxml");
    }
}
