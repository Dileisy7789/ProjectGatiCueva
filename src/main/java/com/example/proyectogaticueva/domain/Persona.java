package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public abstract class Persona {
    private int id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String celular;
    private String correoElectronico;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String sexo;
    private String direccionFotografia;
    private LocalDate FechaCreacion;
    private LocalDate FechaModificacion;
    private LocalDate FechaDeceso;

    public Persona() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setDireccionFotografia(String direccionFotografia) {
        this.direccionFotografia = direccionFotografia;
    }

    public String getDireccionFotografia() {
        return direccionFotografia;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.FechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.FechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaDeceso(LocalDate fechaDeceso) {
        this.FechaDeceso = fechaDeceso;
    }

    public LocalDate getFechaDeceso() {
        return FechaDeceso;
    }
}
