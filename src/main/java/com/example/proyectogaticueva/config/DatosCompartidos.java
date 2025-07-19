package com.example.proyectogaticueva.config;

import com.example.proyectogaticueva.dao.BaseDatosJson;
import com.example.proyectogaticueva.domain.DatosGenerales;

public class DatosCompartidos {
    private static DatosGenerales instancia;

    static {
        recargarDatos();
    }

    public static DatosGenerales getDatos() {
        return instancia;
    }

    public static void recargarDatos() {
        BaseDatosJson db = new BaseDatosJson();
        instancia = db.cargarDatos();
    }

    public static boolean guardarCambios() {
        BaseDatosJson db = new BaseDatosJson();
        return db.guardarDatos(instancia);
    }
}
