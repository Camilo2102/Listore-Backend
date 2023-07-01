package com.example.listore.utils;

public class RequestUtil {

    /**
     * Se encarga de obtener una parte en concreto de la uri
     * @param requestURI la uri desde la que se hizo la peticion
     * @param part la parte de la peticion que vamos a obtener
     * @return la cadena de texto que pertenece a esa parte
     */
    public static String getPartFromURI(String requestURI, int part){
        String[] partsURI = requestURI.split("/");
        return partsURI[part];
    }
}
