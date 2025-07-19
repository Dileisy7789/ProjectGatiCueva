package com.example.proyectogaticueva.dao;

import com.example.proyectogaticueva.config.DatosCompartidos;
import com.example.proyectogaticueva.domain.DatosGenerales;
import com.example.proyectogaticueva.domain.Usuario;
import com.example.proyectogaticueva.util.AuthUtil;
import com.example.proyectogaticueva.util.SesionUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UsuarioDAO
{
    private static DatosGenerales getDatos(){
        return DatosCompartidos.getDatos();
    }

    public static Usuario buscarUsuarioPorDocumento(String numeroDocumento){
        try{
            DatosGenerales datos = getDatos();
            if (datos == null || datos.getUsuarios() == null) return null;
            return datos.getUsuarios().stream().filter(u -> u.getNumeroDocumento().equals(numeroDocumento)).findFirst().orElse(null);
        }catch (Exception Ex){
            return null;
        }
    }

    public static Usuario buscarUsuario(String usuario){
        try {
            DatosGenerales datos = getDatos();
            if(datos == null || datos.getUsuarios() == null) return null;
            return datos.getUsuarios().stream().filter(u -> u.getUsuario().equals(usuario)).findFirst().orElse(null);
        }catch (Exception e){
            return null;
        }
    }

    public static boolean CambiarInformacionUsuario(Usuario usuarioEditado){
        try {
            Usuario existeNuevoUsuario = new Usuario();
            Usuario buscarUsuario = buscarUsuarioPorDocumento(usuarioEditado.getNumeroDocumento());
            if(buscarUsuario == null || buscarUsuario.getUsuario() == null) return false;
            if(!buscarUsuario.getUsuario().equals(usuarioEditado.getUsuario())){
                existeNuevoUsuario = buscarUsuario(usuarioEditado.getUsuario());
            }
            if(existeNuevoUsuario != null) return false;

            buscarUsuario.setTipoDocumento(usuarioEditado.getTipoDocumento());
            buscarUsuario.setNumeroDocumento(usuarioEditado.getNumeroDocumento());
            buscarUsuario.setNombres(usuarioEditado.getNombres());
            buscarUsuario.setApellidos(usuarioEditado.getApellidos());
            buscarUsuario.setCelular(usuarioEditado.getCelular());
            buscarUsuario.setCorreoElectronico(usuarioEditado.getCorreoElectronico());
            buscarUsuario.setFechaNacimiento(usuarioEditado.getFechaNacimiento());
            buscarUsuario.setDireccion(usuarioEditado.getDireccion());
            buscarUsuario.setSexo(usuarioEditado.getSexo());
            buscarUsuario.setActivo(usuarioEditado.getActivo());
            buscarUsuario.setUsuario(usuarioEditado.getUsuario());
            return DatosCompartidos.guardarCambios();
        }catch(Exception Ex) {
            return false;
        }
    }

    public static boolean editarDireccionImagenUsuario(String documento, String direccionImagen){
        try {
            Usuario buscarUsuario = buscarUsuarioPorDocumento(documento);
            if(buscarUsuario == null || buscarUsuario.getUsuario() == null)return false;
            buscarUsuario.setDireccionFotografia(direccionImagen);
            return DatosCompartidos.guardarCambios();

        }catch (Exception Ex){
            return false;
        }
    }

    public static boolean crearUsuario(Usuario nuevoUsuario){
        try{
            boolean respuesta = false;
            Usuario buscarUsuario = buscarUsuarioPorDocumento(nuevoUsuario.getNumeroDocumento());
            Usuario existeNuevoUsuario = buscarUsuario(nuevoUsuario.getUsuario());
            if(buscarUsuario == null && existeNuevoUsuario == null){
                DatosGenerales datos = getDatos();
                datos.getUsuarios().add(nuevoUsuario);
                respuesta = DatosCompartidos.guardarCambios();
            }
            return  respuesta;
        }catch (Exception Ex){
            return false;
        }
    }

    public static  boolean editarCredencial(String usuario, String claveNueva){
        try {
            Usuario buscarUsuario = buscarUsuario(usuario);
            if(buscarUsuario == null || buscarUsuario.getUsuario() == null)return false;
            buscarUsuario.setClave(AuthUtil.encriptarClave(claveNueva));
            return DatosCompartidos.guardarCambios();
        }catch (Exception Ex){
            return false;
        }
    }

    public List<Usuario> listarUsuarios(Boolean activo){
        try{
            DatosGenerales datos = getDatos();
            if(datos == null || datos.getUsuarios() == null) return new ArrayList<>();
            return datos.getUsuarios().stream().filter(u -> u.getActivo() == activo).collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    public static boolean validarCredenciales(String usuario, String clave){
        try{
            Usuario usuarioEncontrado = buscarUsuario(usuario);
            boolean logueado = AuthUtil.validarClave(clave, usuarioEncontrado.getClave());
            if (logueado) {
                SesionUtil.setUsuario(usuarioEncontrado);
            }
            return logueado;
        }catch (Exception Ex){
            return false;
        }
    }


}
