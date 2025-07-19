package com.example.proyectogaticueva.dao;

import com.example.proyectogaticueva.config.DatosCompartidos;
import com.example.proyectogaticueva.controller.AdopcionController;
import com.example.proyectogaticueva.domain.*;
import com.example.proyectogaticueva.util.SesionUtil;

import java.time.LocalDate;

public class AdopcionDAO {
    private static DatosGenerales getDatos(){
        return DatosCompartidos.getDatos();
    }

    public static Adopcion buscarAdopcion(String chipMascota){
        try {
            DatosGenerales datos = getDatos();
            if (datos == null || datos.getAnimales() == null) return null;
            return datos.getAdopciones().stream().filter(adop-> adop.getAnimal().getId().equals(chipMascota)).findFirst().orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    public static boolean cambiarAdopcion(String chipMascota, String documentoAdoptante){
        try {
            Adopcion adopcion = buscarAdopcion(chipMascota);
            Usuario encargado = SesionUtil.getUsuario();
            Adoptante adoptante = getDatos().getAdoptantes().stream().filter(adop -> adop.getNumeroDocumento().equals(documentoAdoptante)).findFirst().orElse(null);
            if(adopcion == null || adoptante == null) return false;
            adopcion.setAdoptante(adoptante);
            adopcion.setEncargado(encargado);
            return DatosCompartidos.guardarCambios();
        }catch (Exception e){
            return false;
        }
    }

    public static boolean crearAdopcion(String chipMascota, String documentoAdoptante){
        try{
            Adopcion adopcion = buscarAdopcion(chipMascota);
            Animal animal = getDatos().getAnimales().stream().filter(a -> a.getId().equals(chipMascota)).findFirst().orElse(null);
            Usuario encargado = SesionUtil.getUsuario();
            Adoptante adoptante = getDatos().getAdoptantes().stream().filter(adop -> adop.getNumeroDocumento().equals(documentoAdoptante)).findFirst().orElse(null);
            if(adopcion != null || adoptante == null) return false;
            int idMaximo = getDatos().getAdopciones().stream().mapToInt(Adopcion::getId).max().orElse(0) + 1;

            Adopcion nuevaAdopcion = new Adopcion(idMaximo, LocalDate.now(), LocalDate.now(), LocalDate.now(), true, adoptante, encargado, animal);

            DatosGenerales datos = getDatos();
            datos.getAdopciones().add(nuevaAdopcion);
            return DatosCompartidos.guardarCambios();
        }catch (Exception e){
            return false;
        }
    }
}
