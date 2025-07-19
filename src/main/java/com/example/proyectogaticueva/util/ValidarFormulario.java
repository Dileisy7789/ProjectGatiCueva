package com.example.proyectogaticueva.util;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.function.UnaryOperator;


public class ValidarFormulario {
    public static void permitirSoloNumeros(TextField campo) {
        UnaryOperator<TextFormatter.Change> filtro = cambio -> {
            return cambio.getControlNewText().matches("\\d*") ? cambio : null;
        };
        campo.setTextFormatter(new TextFormatter<>(filtro));
    }

    public static boolean validarFecha(String fechaTexto){
        if (fechaTexto == null || fechaTexto.isBlank()) return false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaTexto, formatter);
            return fecha.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida: " + e.getMessage());
            return false;
        }
    }
}
