package com.example.proyectogaticueva.util;

import com.example.proyectogaticueva.domain.Usuario;

public class SesionUtil
{
    private static Usuario usuarioActual;

    public static void setUsuario(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
