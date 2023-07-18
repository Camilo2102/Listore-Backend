package com.example.listore.utils;

public class StringUtil {
    public static String getFromTemplate(String template, String... args) {
        return String.format(template, args);
    }
}
