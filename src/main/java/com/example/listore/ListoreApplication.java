package com.example.listore;

import com.example.listore.security.TokenUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListoreApplication {

    public static void main(String[] args) {
        TokenUtil.initializeTokenUtil();
        SpringApplication.run(ListoreApplication.class, args);
    }

}
