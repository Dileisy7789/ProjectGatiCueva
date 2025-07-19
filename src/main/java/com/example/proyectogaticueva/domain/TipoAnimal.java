package com.example.proyectogaticueva.domain;

public class TipoAnimal
{
    private int id;
    private String nombre;

    public TipoAnimal() {}
    public TipoAnimal(int id, String nombre) {
        setId(id);
        setNombre(nombre);
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
