package com.example.proyectogaticueva.dao;

import com.example.proyectogaticueva.config.DatosCompartidos;
import com.example.proyectogaticueva.domain.Animal;
import com.example.proyectogaticueva.domain.DatosGenerales;

public class AnimalDAO {
    private static DatosGenerales getDatos(){
        return DatosCompartidos.getDatos();
    }

    public static Animal buscarAnimalPorCodigo(String identificador){
        try{
            DatosGenerales datos = getDatos();
            if (datos == null || datos.getAnimales() == null) return null;
            return datos.getAnimales().stream().filter(a-> a.getId().equals(identificador)).findFirst().orElse(null);
        }catch(Exception Ex){
            return new Animal();
        }
    }

    public static boolean guardarCambio(Animal animal){
        try {
            Animal buscarAnimal=buscarAnimalPorCodigo(animal.getId());
            if(buscarAnimal == null) return false;
            buscarAnimal.setNombre(animal.getNombre());
            buscarAnimal.setRaza(animal.getRaza());
            buscarAnimal.setSexo(animal.getSexo());
            buscarAnimal.setFechaNacimiento(animal.getFechaNacimiento());
            buscarAnimal.setFechaDeceso(animal.getFechaDeceso());
            buscarAnimal.setTipoAnimal(animal.getTipoAnimal());
            return DatosCompartidos.guardarCambios();
        }catch (Exception Ex){
            return false;
        }
    }

    public static boolean crear(Animal animal){
        try {
            boolean respuesta = false;
            Animal buscarAnimal = buscarAnimalPorCodigo(animal.getId());
            if (buscarAnimal == null){
                DatosGenerales datos = getDatos();
                datos.getAnimales().add(animal);
                respuesta = DatosCompartidos.guardarCambios();
            }
            return respuesta;
        }catch (Exception Ex){
            return false;
        }
    }

    public static boolean editarDireccionImagenAnimal(String identificador, String direccionImagen){
        try {
            Animal buscarAnimal=buscarAnimalPorCodigo(identificador);
            if(buscarAnimal == null) return false;
            buscarAnimal.setDireccionFotografia(direccionImagen);
            return DatosCompartidos.guardarCambios();
        }catch (Exception Ex){
            return false;
        }
    }
}
