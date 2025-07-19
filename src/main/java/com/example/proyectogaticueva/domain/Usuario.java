package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class Usuario extends Persona
{
    private int idUsuario;
    private String usuario;
    private String clave;
    private LocalDate fechaRegistro;
    private LocalDate fechaModificacionUsuario;
    private TipoUsuario tipoUsuario;
    private boolean activo;

    public Usuario() {}
    public Usuario(int idPersona, String tipoDocumento, String numeroDocumento, String nombres,
                   String apellido, String celular, String correoElectronico, LocalDate fechaNacimiento,
                   String direccion, String sexo, String direccionFotografia, LocalDate fechaCreacion,
                   LocalDate fechaModificacion, LocalDate fechaDeceso, int idUsuario, String usuario,
                   String clave, LocalDate fechaRegistro, LocalDate fechaModificacionUsuario, TipoUsuario tipoUsuario,
                   boolean activo) {
        setId(idPersona);
        setTipoDocumento(tipoDocumento);
        setNumeroDocumento(numeroDocumento);
        setNombres(nombres);
        setApellidos(apellido);
        setCelular(celular);
        setCorreoElectronico(correoElectronico);
        setFechaNacimiento(fechaNacimiento);
        setDireccion(direccion);
        setSexo(sexo);
        setDireccionFotografia(direccionFotografia);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
        setFechaDeceso(fechaDeceso);

        //Getters y Setters
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
        this.setClave(clave);
        this.setFechaRegistro(fechaRegistro);
        this.setFechaModificacionUsuario(fechaModificacionUsuario);
        this.setTipoUsuario(tipoUsuario);
        this.setActivo(activo);
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario(){
        return usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave(){
        return clave;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRegistro(){
        return fechaRegistro;
    }

    public void setFechaModificacionUsuario(LocalDate fechaModificacion) {
        this.fechaModificacionUsuario = fechaModificacion;
    }

    public LocalDate getFechaModificacionUsuario(){
        return fechaModificacionUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario getTipoUsuario(){
        return tipoUsuario;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getActivo(){
        return activo;
    }

}
