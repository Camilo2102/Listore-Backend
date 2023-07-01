package com.example.listore.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final long EXPIRATION_TIME = 86400000;

    private static Algorithm algorithm;
    private static Map<String, RSAKey> keys;

    /**
     *
     * @param payload data que va a ser almacenada en el jwt
     * @return jwt creado a partir de la data y el algoritmo establecido
     */
    public static String generateToken(Map<String, String> payload) {
        return JWT.create().withPayload(payload).withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(algorithm);
    }

    /**
     *
     * @param token token recibido del usuario
     * @return estado de la validacion del token
     */
    public static Map<String, Claim> validateToken(String token) {
        JWTVerifier jwt = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwt.verify(token);
        return decodedJWT.getClaims();
    }

    /**
     * Se encarga de inicializar los valores necesarios para crear el alghoritmo de encripcion
     */
    public static void initializeTokenUtil() {
        Map<String, RSAKey> keys = generateRSAKey();
        algorithm = Algorithm.RSA256((RSAPublicKey) keys.get("public"), (RSAPrivateKey) keys.get("private"));
    }

    /**
     * Genera las claves rsa necesarias para generar el algoritmo de encripcion
     * @return claves rsa
     */

    private static Map<String, RSAKey> generateRSAKey() {
        Map<String, RSAKey> keys = new HashMap<>();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); // Tamaño de clave: 2048 bits
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Obtener la clave privada y pública
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            keys.put("public", (RSAKey) publicKey);
            keys.put("private", (RSAKey) privateKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return keys;
    }

}
