package com.example.proyectogaticueva.controller;

import com.example.proyectogaticueva.dao.UsuarioDAO;
import com.example.proyectogaticueva.domain.TipoUsuario;
import com.example.proyectogaticueva.domain.Usuario;
import com.example.proyectogaticueva.util.AlertaUtil;
import com.example.proyectogaticueva.util.ImagenUtil;
import com.example.proyectogaticueva.util.ValidarFormulario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioController {
    @FXML private ImageView imgUsuario;
    @FXML private Button btnSubirFoto;
    @FXML private Button btnBuscarPersona;
    @FXML private Label lblBuscarDocumento;
    @FXML private Button btnEditarUsuario;
    @FXML private Button btnCrearUsuario;
    @FXML private TextField txtTipoUsuario;
    @FXML private TextField txtNumeroDocumento;
    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtCelular;
    @FXML private TextField txtCorreoElectronico;
    @FXML private TextField txtfechaNacimiento;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtSexo;
    @FXML private TextField txtUsuario;
    @FXML private RadioButton rdbUsuarioActivo;
    @FXML private TextField txtTipoDocumento;
    @FXML private TextField txtNumeroDocumentoBuscar;

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void buscarUsuario(ActionEvent actionEvent) {
        Usuario usuarioInformacion = UsuarioDAO.buscarUsuarioPorDocumento(txtNumeroDocumentoBuscar.getText().trim());
        if(usuarioInformacion == null) {
            AlertaUtil.mostrarInfo("No hay información registrada del usuario ingresado");
        }else{
            mostrarImagenUsuario(usuarioInformacion);
            txtTipoDocumento.setText(usuarioInformacion.getTipoDocumento());
            txtNumeroDocumento.setText(usuarioInformacion.getNumeroDocumento());
            txtNombres.setText(usuarioInformacion.getNombres());
            txtApellidos.setText(usuarioInformacion.getApellidos());
            txtCelular.setText(usuarioInformacion.getCelular());
            txtCorreoElectronico.setText(usuarioInformacion.getCorreoElectronico());
            txtfechaNacimiento.setText(usuarioInformacion.getFechaNacimiento().format(formatoFecha));
            txtDireccion.setText(usuarioInformacion.getDireccion());
            txtSexo.setText(usuarioInformacion.getSexo());
            txtUsuario.setText(usuarioInformacion.getUsuario());
            rdbUsuarioActivo.setSelected(usuarioInformacion.getActivo());
        }
    }

    public void guardarCambioUsuario(ActionEvent actionEvent) {
        boolean guardarCambios = UsuarioDAO.CambiarInformacionUsuario(devolverDatosFormulario());
        if(guardarCambios){
            AlertaUtil.mostrarInfo("Usuario guardado correctamente");
        }else{
            AlertaUtil.mostrarInfo("Los cambios no se hicieron exitosamente");
        }
        limpiarFormulario();
    }

    public void crearUsuario(ActionEvent actionEvent) {
        boolean guardarNuevoUsuario = UsuarioDAO.crearUsuario(devolverDatosFormulario());
        if(guardarNuevoUsuario){
            AlertaUtil.mostrarInfo("Usuario guardado correctamente");
        }else{
            AlertaUtil.mostrarInfo("Los cambios no se hicieron exitosamente");
        }
        limpiarFormulario();
    }

    public void cargarImagen(ActionEvent actionEvent) {
        String numeroDocumento = txtNumeroDocumento.getText().trim();
        String rutaImagen= ImagenUtil.cargarImagenEnImageView((Stage) btnSubirFoto.getScene().getWindow(), numeroDocumento, "imagenesUsuario");
        if(rutaImagen != null){
            boolean guardarRutaImagen=UsuarioDAO.editarDireccionImagenUsuario(numeroDocumento, rutaImagen);
            if(guardarRutaImagen){
                AlertaUtil.mostrarInfo("Se ha guardado la foto correctamente.");
                mostrarImagenUsuario(devolverDatosFormulario());
            }else{
                AlertaUtil.mostrarInfo("No se ha podido guardar la foto correctamente.");
            }
        }
    }

    private void mostrarImagenUsuario(Usuario usuario){
       ImagenUtil.cargarImagenGuardada(usuario.getDireccionFotografia(), imgUsuario);
    }

    private boolean validarCampos(){
        return !txtNumeroDocumento.getText().trim().isEmpty() && !txtNombres.getText().trim().isEmpty()
                && !txtApellidos.getText().trim().isEmpty() && !txtCelular.getText().trim().isEmpty()
                && !txtCorreoElectronico.getText().trim().isEmpty() && !txtfechaNacimiento.getText().trim().isEmpty()
                && !txtDireccion.getText().trim().isEmpty() && !txtSexo.getText().trim().isEmpty();

    }

    private Usuario devolverDatosFormulario(){
        Usuario usuarioFormulario=new Usuario();

        if(validarCampos() && !ValidarFormulario.validarFecha(txtfechaNacimiento.getText())){

            String tipoDocumento = txtTipoDocumento.getText().trim();
            String numeroDocumento = txtNumeroDocumento.getText().trim();
            String nombres = txtNombres.getText().trim();
            String apellidos = txtApellidos.getText().trim();
            String celular = txtCelular.getText().trim();
            String correoElectronico = txtCorreoElectronico.getText().trim();
            LocalDate fechaNacimiento = LocalDate.parse(txtfechaNacimiento.getText().trim(), formatoFecha);
            String direccion = txtDireccion.getText().trim();
            String sexo = txtSexo.getText().trim();
            boolean activo = rdbUsuarioActivo.isSelected();
            String usuario= txtUsuario.getText().trim();
            TipoUsuario tipoUsuario=new TipoUsuario();

            usuarioFormulario= new Usuario(0, tipoDocumento, numeroDocumento, nombres, apellidos,
                    celular, correoElectronico, fechaNacimiento, direccion, sexo, "", LocalDate.now(),
                    LocalDate.now(), LocalDate.parse("01/01/1900", formatoFecha), 0, usuario, "", LocalDate.now(), LocalDate.now(), tipoUsuario , activo);

        }
        return usuarioFormulario;
    }

    public void accionesFormulario(boolean crearUsuario){
        btnEditarUsuario.setVisible(false);
        btnBuscarPersona.setVisible(false);
        btnCrearUsuario.setVisible(false);
        btnSubirFoto.setVisible(false);
        txtNumeroDocumentoBuscar.setVisible(false);
        lblBuscarDocumento.setVisible(false);
        txtNumeroDocumento.setDisable(false);

        if(crearUsuario){
            txtNumeroDocumento.setDisable(false);
            btnCrearUsuario.setVisible(true);
        }else{
            btnEditarUsuario.setVisible(true);
            btnBuscarPersona.setVisible(true);
            btnSubirFoto.setVisible(true);
            txtNumeroDocumentoBuscar.setVisible(true);
            lblBuscarDocumento.setVisible(true);
        }
    }

    private void limpiarFormulario(){
        txtTipoDocumento.clear();
        txtNumeroDocumento.clear();
        txtNombres.clear();
        txtApellidos.clear();
        txtCelular.clear();
        txtCorreoElectronico.clear();
        txtfechaNacimiento.clear();
        txtDireccion.clear();
        txtSexo.clear();
        txtUsuario.clear();
    }


}
