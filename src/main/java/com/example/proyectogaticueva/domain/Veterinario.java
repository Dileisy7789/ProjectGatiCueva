package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class Veterinario extends Persona
{
    private int idVeterinario;
    private String tituloUniversitario;
    private String matriculaProfesional;
    private String especialidad;
    private String agnosExperiencia;

    public  Veterinario(){}
    public Veterinario(int idPersona, String tipoDocumento, String numeroDocumento, String nombres,
                       String apellido, String celular, String correoElectronico, LocalDate fechaNacimiento,
                       String direccion, String sexo, String direccionFotografia, LocalDate fechaCreacion,
                       LocalDate fechaModificacion, LocalDate fechaDeceso, int idVeterinario, String tituloUniversitario,
                       String matriculaProfesional, String especialidad, String agnosExperiencia) {
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
        this.setIdVeterinario(idVeterinario);
        this.setTituloUniversitario(tituloUniversitario);
        this.setMatriculaProfessional(matriculaProfesional);
        this.setEspecialidad(especialidad);
        this.setAgnosExperiencia(agnosExperiencia);
    }

    public void setIdVeterinario(int id) {
        this.idVeterinario = id;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setTituloUniversitario(String tituloUniversitario) {
        this.tituloUniversitario = tituloUniversitario;
    }

    public String getTituloUniversitario() {
        return tituloUniversitario;
    }

    public void setMatriculaProfessional(String matriculaProfessional) {
        this.matriculaProfesional = matriculaProfessional;
    }

    public String getMatriculaProfessional() {
        return matriculaProfesional;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setAgnosExperiencia(String agnosExperiencia) {
        this.agnosExperiencia = agnosExperiencia;
    }

    public String getAgnosExperiencia() {
        return agnosExperiencia;
    }
}
