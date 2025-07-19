package com.example.proyectogaticueva.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertaUtil {
    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Ocurrió un error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public static void mostrarAdvertencia(String mensaje) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
