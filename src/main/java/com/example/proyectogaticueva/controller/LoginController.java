package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.dao.UsuarioDAO;
import com.example.proyectogaticueva.util.AlertaUtil;
import com.example.proyectogaticueva.util.VistaControlador;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtClave;

    @FXML
    private Button btningresar;

    @FXML
    public void initialize() {
        ChangeListener<String> listener = (obs, oldVal, newVal)->  validarCampos();
        txtUsuario.textProperty().addListener(listener);
        txtClave.textProperty().addListener(listener);

    }

    private void validarCampos(){
        boolean camposLlenos=!txtUsuario.getText().isEmpty() && !txtClave.getText().isEmpty();
        btningresar.setDisable(!camposLlenos);
    }

    public void handleIngresarUsuario(javafx.event.ActionEvent actionEvent) throws IOException {
        if(UsuarioDAO.validarCredenciales(txtUsuario.getText(), txtClave.getText())){
            MenuController controller = VistaControlador.cargarVista("/com/example/proyectogaticueva/views/menu.fxml", actionEvent);
        }else {
            AlertaUtil.mostrarInfo("Su usuario o contraseña es incorrecto");
        }
    }
}
