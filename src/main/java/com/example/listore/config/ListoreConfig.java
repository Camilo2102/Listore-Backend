package com.example.listore.config;

import com.example.listore.interceptores.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ListoreConfig implements WebMvcConfigurer {

    //Interceptor para validar el token
    @Autowired
    TokenHandler tokenHandler;

    /**
     * Agrega validaciones intermedias para las rutas especificacdas
     * @param registry registro de interceptores
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(tokenHandler).addPathPatterns("/auth/**");
    }


    /**
     * Registro de cors y metodos permitidos
     * @param registry registro de cors
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000/")
                .allowedMethods("PUT", "DELETE", "POST", "GET")
                .allowCredentials(true).maxAge(3600);
    }
}
