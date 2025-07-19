package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.dao.UsuarioDAO;
import com.example.proyectogaticueva.util.AlertaUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EditarCredencialController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtClaveUno;
    @FXML private PasswordField txtClaveDos;

    public void guardarCambios(ActionEvent actionEvent) {
        String usuario = txtUsuario.getText();
        String claveUno = txtClaveUno.getText();
        String claveDos = txtClaveDos.getText();

        if(!claveUno.equals(claveDos) || !validarCampos() ){
            AlertaUtil.mostrarInfo("Las claves no coinciden.");
        }else{
            boolean guardarCredenciales = UsuarioDAO.editarCredencial(usuario, claveUno);
            if(guardarCredenciales){
                AlertaUtil.mostrarInfo("Credenciales guardada con exito.");
            }else{
                AlertaUtil.mostrarInfo("No se encontró al usuario, verifique.");
            }
        }
    }

    private boolean validarCampos(){
        return !txtUsuario.getText().trim().isEmpty() && !txtClaveUno.getText().trim().isEmpty()
                && !txtClaveDos.getText().trim().isEmpty();
    }
}
