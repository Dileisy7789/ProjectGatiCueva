package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class Animal {
    private String id;
    private String nombre;
    private String raza;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private String sexo;
    private String direccionFotografia;
    private LocalDate fechaDeceso;
    private TipoAnimal tipoAnimal;

    public Animal() {}
    public Animal(String id, String nombre, String raza, LocalDate fechaNacimiento,
                  LocalDate fechaRegistro, String sexo, String direccionFotografia, TipoAnimal tipoAnimal,
                  LocalDate fechaDeceso ) {
        //Getters y Setters
        this.setId(id);
        this.setNombre(nombre);
        this.setRaza(raza);
        this.setFechaNacimiento(fechaNacimiento);
        this.setFechaRegistro(fechaRegistro);
        this.setSexo(sexo);
        this.setDireccionFotografia(direccionFotografia);
        this.setFechaDeceso(fechaDeceso);
        this.setTipoAnimal(tipoAnimal);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
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

    public void setFechaDeceso(LocalDate fechaDeceso) {
        this.fechaDeceso = fechaDeceso;
    }

    public LocalDate getFechaDeceso() {
        return fechaDeceso;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }
}
