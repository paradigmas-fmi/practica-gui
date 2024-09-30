package org.practicagui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class SceneController {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    protected CineController cineController = CineController.getInstance();

    protected void switchScene(ActionEvent e, String scenePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scenePath));
        this.root = loader.load();
        SceneController newSceneController = loader.getController();
        this.stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void showAlert(AlertType tipoAlerta, String title, String header, String content) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(content);
        alerta.showAndWait();
    }
}