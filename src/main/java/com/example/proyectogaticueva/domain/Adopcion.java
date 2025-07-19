package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class Adopcion {
    private int id;
    private LocalDate fechaAdopcion;
    private LocalDate fechaDeSeguimiento;
    private LocalDate fechaModificacion;
    private Adoptante adoptante;
    private Usuario encargado;
    private Animal animal;
    private boolean activo;

    public Adopcion(){}
    public Adopcion(int id, LocalDate fechaAdopcion, LocalDate fechaDeSeguimiento,
                    LocalDate fechaModificacion, boolean activo, Adoptante adoptante, Usuario encargado, Animal animal) {
        this.setId(id);
        this.setFechaAdopcion(fechaAdopcion);
        this.setFechaDeSeguimiento(fechaDeSeguimiento);
        this.setFechaModificacion(fechaModificacion);
        this.setActivo(activo);
        this.setAdoptante(adoptante);
        this.setEncargado(encargado);
        this.setAnimal(animal);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFechaAdopcion(LocalDate fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaDeSeguimiento(LocalDate fechaDeSeguimiento) {
        this.fechaDeSeguimiento = fechaDeSeguimiento;
    }

    public LocalDate getFechaDeSeguimiento() {
        return fechaDeSeguimiento;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setEncargado(Usuario encargado) {
        this.encargado = encargado;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
