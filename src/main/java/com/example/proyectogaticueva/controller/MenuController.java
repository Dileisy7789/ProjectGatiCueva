package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.util.VistaControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController {
    @FXML
    private AnchorPane contenedorCentral;

    @FXML
    public void initialize() {
        // Al iniciar, se carga usuario.fxml por defecto
        VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/usuario.fxml", contenedorCentral);
    }

    public void editarUsuario(ActionEvent actionEvent) {
        UsuarioController controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/usuario.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(false);
        }
    }

    public void crearUsuario(ActionEvent actionEvent) {
        UsuarioController controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/usuario.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(true);
        }
    }

    public void editarCredenciales(ActionEvent actionEvent) {
        UsuarioController controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/editarCredencial.fxml", contenedorCentral);
    }

    public void crearAnimal(ActionEvent actionEvent) {
        AnimalController  controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/animal.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(true);
        }
    }

    public void editarAnimal(ActionEvent actionEvent) {
        AnimalController  controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/animal.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(false);
        }
    }

    public void crearAdopcion(ActionEvent actionEvent) {
        AdopcionController  controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/adopcion.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(true);
        }
    }

    public void editarAdopcion(ActionEvent actionEvent) {
        AdopcionController  controlador = VistaControlador.cargarEnContenedor("/com/example/proyectogaticueva/views/adopcion.fxml", contenedorCentral);
        if (controlador != null) {
            controlador.accionesFormulario(false);
        }
    }
}
