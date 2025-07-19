package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.dao.AnimalDAO;
import com.example.proyectogaticueva.dao.UsuarioDAO;
import com.example.proyectogaticueva.domain.Animal;
import com.example.proyectogaticueva.domain.TipoAnimal;
import com.example.proyectogaticueva.domain.Usuario;
import com.example.proyectogaticueva.util.AlertaUtil;
import com.example.proyectogaticueva.util.ImagenUtil;
import com.example.proyectogaticueva.util.ValidarFormulario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalController {
    @FXML private ImageView imgAnimal;
    @FXML private Button btnSubirFoto;
    @FXML private Label lblBuscarIdentificador;
    @FXML private Button btnCrearAnimal;
    @FXML private Button btnBuscarAnimal;
    @FXML private Button btnGuardarAnimal;
    @FXML private TextField txtBuscarIdentificador;
    @FXML private TextField txtIdentificador;
    @FXML private TextField txtNombre;
    @FXML private TextField txtFechaNacimiento;
    @FXML private TextField txtSexo;
    @FXML private TextField txtRaza;
    @FXML private TextField txtFechaDeceso;

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void buscarAnimal(ActionEvent actionEvent) {
        String identificador = txtBuscarIdentificador.getText().trim();
        Animal buscarAnimal= AnimalDAO.buscarAnimalPorCodigo(identificador);
        if(buscarAnimal != null) {
            mostrarImagenUsuario(buscarAnimal);
            LocalDate fechaDeceso = buscarAnimal.getFechaDeceso() == null ? LocalDate.of(1900, 1, 1) : buscarAnimal.getFechaDeceso();
            txtIdentificador.setText(buscarAnimal.getId());
            txtNombre.setText(buscarAnimal.getNombre());
            txtFechaNacimiento.setText(buscarAnimal.getFechaNacimiento().format(formatoFecha));
            txtSexo.setText(buscarAnimal.getSexo());
            txtFechaDeceso.setText(fechaDeceso.format(formatoFecha));
            txtRaza.setText(buscarAnimal.getRaza());
        }else{
            AlertaUtil.mostrarInfo("No se encontro el animal con el chip seleccionado.");
        }
    }

    public void guardarCambioAnimal(ActionEvent actionEvent) {
        boolean guardarCambios = AnimalDAO.guardarCambio(devolverDatosFormulario());
        if (guardarCambios){
            AlertaUtil.mostrarInfo("Los cambios fueron exitosos");
            limpiarFormulario();
        }else {
            AlertaUtil.mostrarInfo("No se ha podido guardar los cambios");
        }
    }

    public void crearAnimal(ActionEvent actionEvent) {
        boolean guardarCambios = AnimalDAO.crear(devolverDatosFormulario());
        if (guardarCambios){
            AlertaUtil.mostrarInfo("Los cambios fueron exitosos");
            limpiarFormulario();
        }else{
            AlertaUtil.mostrarInfo("No se ha podido guardar los cambios");
        }
    }

    public void cargarImagen(ActionEvent actionEvent) {
        String identificador = txtIdentificador.getText().trim();
        String rutaImagen= ImagenUtil.cargarImagenEnImageView((Stage) btnSubirFoto.getScene().getWindow(), identificador, "imagenesAnimal");
        if(rutaImagen != null){
            boolean guardarRutaImagen= AnimalDAO.editarDireccionImagenAnimal(identificador, rutaImagen);
            if(guardarRutaImagen){
                AlertaUtil.mostrarInfo("Se ha guardado la foto correctamente.");
                mostrarImagenUsuario(devolverDatosFormulario());
            }else{
                AlertaUtil.mostrarInfo("No se ha podido guardar la foto correctamente.");
            }
        }
    }

    private void mostrarImagenUsuario(Animal animal){
        ImagenUtil.cargarImagenGuardada(animal.getDireccionFotografia(), imgAnimal);
    }

    private Animal devolverDatosFormulario(){
        Animal modificarAnimal= new Animal();
        if(validarCampos() && !ValidarFormulario.validarFecha(txtFechaNacimiento.getText()) && !ValidarFormulario.validarFecha(txtFechaDeceso.getText())){
            TipoAnimal tipoAnimal = new TipoAnimal(2, "Gato");
            String identificador = txtIdentificador.getText();
            String nombre = txtNombre.getText();
            String fechaNacimiento = txtFechaNacimiento.getText();
            String sexo = txtSexo.getText();
            LocalDate fechaDeceso = txtFechaDeceso.getText() == null || txtFechaDeceso.getText().equals("") ? LocalDate.of(1900, 1, 1) : LocalDate.parse(txtFechaDeceso.getText(), formatoFecha);;
            String raza = txtRaza.getText();

            modificarAnimal= new Animal(identificador, nombre, raza, LocalDate.parse(fechaNacimiento, formatoFecha),
                    LocalDate.now(), sexo, "", tipoAnimal, fechaDeceso);
        }
        return modificarAnimal;
    }

    private boolean validarCampos(){
        return !txtIdentificador.getText().trim().isEmpty() && !txtNombre.getText().trim().isEmpty()
                && !txtFechaNacimiento.getText().trim().isEmpty() && !txtSexo.getText().trim().isEmpty()
                && !txtRaza.getText().trim().isEmpty();
    }

    public void accionesFormulario(boolean crearAnimal){
        lblBuscarIdentificador.setVisible(false);
        txtBuscarIdentificador.setVisible(false);
        txtIdentificador.setDisable(true);
        btnCrearAnimal.setVisible(false);
        btnBuscarAnimal.setVisible(false);
        btnGuardarAnimal.setVisible(false);
        btnSubirFoto.setVisible(false);

        if (crearAnimal){
            btnCrearAnimal.setVisible(true);
            txtIdentificador.setDisable(false);
        }
        else{
            lblBuscarIdentificador.setVisible(true);
            txtBuscarIdentificador.setVisible(true);
            btnGuardarAnimal.setVisible(true);
            btnBuscarAnimal.setVisible(true);
            btnSubirFoto.setVisible(true);
        }
    }

    private void limpiarFormulario(){
        txtIdentificador.clear();
        txtNombre.clear();
        txtSexo.clear();
        txtRaza.clear();
        txtFechaNacimiento.clear();
        txtFechaDeceso.clear();
    }



}
