package com.example.listore;

import com.example.listore.models.triggers.TriggerCreator;
import com.example.listore.utils.EmailUtil;
import com.example.listore.utils.TokenUtil;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Listore api",
                version = "0.1",
                description = "Listado de endpoints de listore",
                license = @License(name = "Apache 2.0", url = "http://nose:&"),
                contact = @Contact(url = "http://listore.com", name = "Listore", email = "listore@mail.com")
        )
)
@ComponentScan(basePackages = "com.example.listore.repository")
@ComponentScan(basePackages = "com.example.listore.models.triggers")
@EnableCaching
public class ListoreApplication implements CommandLineRunner {

    private final TriggerCreator triggerCreator;

    @Autowired
    public ListoreApplication(TriggerCreator triggerCreator) {
        this.triggerCreator = triggerCreator;
    }

    public static void main(String[] args) {
        SpringApplication.run(ListoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        triggerCreator.initializeTriggers();
        initializeValues();
    }

    private void initializeValues() {
        TokenUtil.initializeTokenUtil();
        EmailUtil.initializeEmailUtil();
    }
}