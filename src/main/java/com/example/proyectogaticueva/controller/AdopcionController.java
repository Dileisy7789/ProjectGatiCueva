package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.dao.AdopcionDAO;
import com.example.proyectogaticueva.domain.Adopcion;
import com.example.proyectogaticueva.util.AlertaUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdopcionController {
    @FXML private Label lblBuscarMascota;
    @FXML private TextField txtIdMascotaBuscar;
    @FXML private Button btnBucarMascota;
    @FXML private TextField txtIdMascota;
    @FXML private TextField txtDocumentoEncargado;
    @FXML private TextField txtFechaSeguimiento;
    @FXML private TextField txtDocumentoAdoptante;
    @FXML private TextField txtFechaAdopcion;
    @FXML private Button btnGuardar;
    @FXML private Button btnModificar;

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formatoStringFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void buscarAdopcion(ActionEvent actionEvent) {
        String idMascota = txtIdMascotaBuscar.getText().trim();
        Adopcion buscarAdopcion=AdopcionDAO.buscarAdopcion(idMascota);
        if(buscarAdopcion != null){
            txtIdMascota.setText(buscarAdopcion.getAnimal().getId());
            txtDocumentoAdoptante.setText(buscarAdopcion.getAdoptante().getNumeroDocumento());
            txtDocumentoEncargado.setText(buscarAdopcion.getEncargado().getNumeroDocumento());
            txtFechaAdopcion.setText(formatoStringFecha.format(buscarAdopcion.getFechaAdopcion()));
            txtFechaSeguimiento.setText(formatoStringFecha.format(buscarAdopcion.getFechaDeSeguimiento()));
        }
    }

    public void crearAdopcion(ActionEvent actionEvent) {
        if(validarCampos()) {
            String idMascota = txtIdMascota.getText().trim();
            String documentoAdoptante = txtDocumentoAdoptante.getText().trim();

            boolean crearAdopcion = AdopcionDAO.crearAdopcion(idMascota, documentoAdoptante);
            if (crearAdopcion) {
                AlertaUtil.mostrarInfo("Se creo la adopcion con exito");
                limpiarFormulario();
            } else {
                AlertaUtil.mostrarError("No se creo la adopcion con exito");
            }
        }
    }

    public void guardarCambioAdopcion(ActionEvent actionEvent) {
        if (validarCampos()) {
            String idMascota = txtIdMascota.getText().trim();
            String documentoAdoptante = txtDocumentoAdoptante.getText().trim();

            boolean crearAdopcion = AdopcionDAO.cambiarAdopcion(idMascota, documentoAdoptante);
            if (crearAdopcion) {
                AlertaUtil.mostrarInfo("Se guardo la adopcion con exito");
                limpiarFormulario();
            } else {
                AlertaUtil.mostrarError("No se guardo la adopcion con exito");
            }
        }
    }

    private boolean validarCampos(){
        return !txtIdMascota.getText().trim().isEmpty() && !txtDocumentoEncargado.getText().trim().isEmpty()
                && !txtFechaSeguimiento.getText().trim().isEmpty() && !txtFechaAdopcion.getText().trim().isEmpty()
                && !txtDocumentoAdoptante.getText().trim().isEmpty();
    }

    public void accionesFormulario(boolean crearAdopcion){
        txtIdMascotaBuscar.setVisible(false);
        lblBuscarMascota.setVisible(false);
        btnBucarMascota.setVisible(false);
        btnGuardar.setVisible(false);
        btnModificar.setVisible(false);
        if (crearAdopcion){
            btnGuardar.setVisible(true);
        }else {
            txtIdMascotaBuscar.setVisible(true);
            lblBuscarMascota.setVisible(true);
            btnBucarMascota.setVisible(true);
            btnModificar.setVisible(true);
        }

    }

    private void limpiarFormulario(){
        txtIdMascota.clear();
        txtDocumentoEncargado.clear();
        txtFechaSeguimiento.clear();
        txtFechaAdopcion.clear();
        txtDocumentoAdoptante.clear();
    }
}
