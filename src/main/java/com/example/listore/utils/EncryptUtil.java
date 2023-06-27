package com.example.listore.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class EncryptUtil {

    public static String encryptValue(String password) {
        return BCrypt.withDefaults().hashToString(6, password.toCharArray());
    }

    public static boolean checkValues(String value, String hashedValue) {
        return BCrypt.verifyer().verify(value.toCharArray(), hashedValue.toCharArray()).verified;
    }
}
