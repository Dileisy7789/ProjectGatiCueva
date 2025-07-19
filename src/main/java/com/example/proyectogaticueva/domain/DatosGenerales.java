package com.example.proyectogaticueva.domain;

import java.util.List;

public class DatosGenerales
{
    private List<Veterinario> veterinarios;
    private List<Usuario> usuarios;
    private List<Adoptante> adoptantes;
    private List<TipoUsuario> tipoUsuarios;
    private List<TipoAnimal> tiposAnimal;
    private List<Animal> animales;
    private List<RegistroMedicoAnimal> registrosMedicos;
    private List<Adopcion> adopciones;

    // Getters y setters
    public List<Veterinario> getVeterinarios() { return veterinarios; }
    public void setVeterinarios(List<Veterinario> veterinarios) { this.veterinarios = veterinarios; }

    public List<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }

    public List<Adoptante> getAdoptantes() { return adoptantes; }
    public void setAdoptantes(List<Adoptante> adoptantes) { this.adoptantes = adoptantes; }

    public List<TipoUsuario> getTipoUsuarios() { return tipoUsuarios; }
    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) { this.tipoUsuarios = tipoUsuarios; }

    public List<TipoAnimal> getTiposAnimal() { return tiposAnimal; }
    public void setTiposAnimal(List<TipoAnimal> tiposAnimal) { this.tiposAnimal = tiposAnimal; }

    public List<Animal> getAnimales() { return animales; }
    public void setAnimales(List<Animal> animales) { this.animales = animales; }

    public List<RegistroMedicoAnimal> getRegistrosMedicos() { return registrosMedicos; }
    public void setRegistrosMedicos(List<RegistroMedicoAnimal> registrosMedicos) { this.registrosMedicos = registrosMedicos; }

    public List<Adopcion> getAdopciones() { return adopciones; }
    public void setAdopciones(List<Adopcion> adopciones) { this.adopciones = adopciones; }

}
