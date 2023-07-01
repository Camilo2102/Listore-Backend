package com.example.listore.utils;

import java.util.UUID;

public class IdGeneratorUtil {

    /**
     * Genera id unicos
     * @return Id unico
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
