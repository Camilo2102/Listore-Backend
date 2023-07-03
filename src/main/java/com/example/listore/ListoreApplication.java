package com.example.listore;

import com.example.listore.utils.TokenUtil;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class ListoreApplication {

    public static void main(String[] args) {
        TokenUtil.initializeTokenUtil();
        SpringApplication.run(ListoreApplication.class, args);
    }

}
