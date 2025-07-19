package com.example.proyectogaticueva.util;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaControlador {
    public static <T> T cargarVista(String rutaFXML, ActionEvent evento) {
        try {
            FXMLLoader loader = new FXMLLoader(VistaControlador.class.getResource(rutaFXML));
            Parent root = loader.load();

            // Mostrar escena
            Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            // Retorna el controlador por si lo necesitas
            return loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T cargarEnContenedor(String rutaFXML, AnchorPane contenedor) {
        try {
            System.out.println("Cargando vista: " + rutaFXML);
            FXMLLoader loader = new FXMLLoader(VistaControlador.class.getResource(rutaFXML));
            Parent vista = loader.load();

            contenedor.getChildren().setAll(vista);
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
