package org.practicagui.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.practicagui.View.PeliculaView;
import org.practicagui.View.ProyeccionView;

import java.io.IOException;
import java.util.ArrayList;

public class SeleccionPeliculaController extends SceneController {

    @FXML
    ComboBox<PeliculaView> dropdownPeliculas;

    @FXML
    ComboBox<ProyeccionView> dropdownFuncion;

    @FXML
    ImageView poster;

    @FXML
    public void initialize() {
        ArrayList<PeliculaView> peliculasView = cineController.getPeliculasView();
        peliculasView.add(0,null);
        ObservableList<PeliculaView> peliculasList = FXCollections.observableArrayList(peliculasView);
        dropdownPeliculas.setItems(peliculasList);
    }

    @FXML
    public void handleDropdownPelicula(ActionEvent e) throws IOException {
        ArrayList<ProyeccionView> proyeccionesView;
        PeliculaView seleccionPelicula = dropdownPeliculas.getValue();
        if (seleccionPelicula != null) {
            try {
                String imagePath = getClass().getResource(String.format("/org/practicagui/images/%s", seleccionPelicula.getPathImagenAsociada())).toString();
                poster.setImage(new Image(imagePath));
                cineController.seleccionarPelicula(seleccionPelicula);
                proyeccionesView = cineController.getProyeccionesViewPelicula(cineController.getPeliculaSeleccionada());
                ObservableList<ProyeccionView> proyeccionesList = FXCollections.observableArrayList(proyeccionesView);
                dropdownFuncion.setItems(proyeccionesList);
            } catch (RuntimeException ex) {
                System.err.println("Error loading image: " + ex.getMessage());
            }
        } else {
            String imagePath = getClass().getResource("/org/practicagui/images/default-poster.png").toString();
            poster.setImage(new Image(imagePath));
            proyeccionesView = new ArrayList<>();
            proyeccionesView.add(null);
            ObservableList<ProyeccionView> proyeccionesList = FXCollections.observableArrayList();
            dropdownFuncion.setItems(proyeccionesList);
        }
    }

    @FXML
    public void handleDropdownFuncion(ActionEvent e) {
        ProyeccionView seleccionFuncion = dropdownFuncion.getValue();
        if (seleccionFuncion != null) {
            cineController.seleccionarProyeccion(seleccionFuncion);
        }
    }

    @FXML
    public void handleConfirmationButtonAction(ActionEvent e) throws IOException {
        if (this.cineController.getPeliculaSeleccionada() != null && this.cineController.getProyeccionSeleccionada() != null) {
            this.switchScene(e, "/SeleccionButaca.fxml");
        } else {
            this.showAlert(Alert.AlertType.WARNING, "Campos sin seleccionar", null, "Por favor seleccione una película y función.");
        }

    }
}
