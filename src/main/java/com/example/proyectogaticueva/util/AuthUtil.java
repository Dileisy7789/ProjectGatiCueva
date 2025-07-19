package com.example.proyectogaticueva.util;

import org.mindrot.jbcrypt.BCrypt;

public class AuthUtil
{

    public static String encriptarClave(String clavePlana){
        return  BCrypt.hashpw(clavePlana, BCrypt.gensalt());
    }

    public static boolean validarClave(String clavePlana, String claveSistema){
        return BCrypt.checkpw(clavePlana, claveSistema);
    }


}
