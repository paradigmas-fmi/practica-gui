package org.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        VBox root = loader.load();

        // Crear una escena
        Scene scene = new Scene(root, 800, 600); // Tamaño de la ventana (800x600)

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
