package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class Adoptante extends Persona
{
    public Adoptante(){}
    public Adoptante(int idPersona, String tipoDocumento, String numeroDocumento, String nombres,
                      String apellido, String celular, String correoElectronico, LocalDate fechaNacimiento,
                      String direccion, String sexo, String direccionFotografia, LocalDate fechaCreacion,
                      LocalDate fechaModificacion, LocalDate fechaDeceso){
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
    }
}
