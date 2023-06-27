package com.example.listore.config;

import com.example.listore.interceptores.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ListoreConfig implements WebMvcConfigurer {

    @Autowired
    TokenHandler tokenHandler;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenHandler).addPathPatterns("/users/**");
    }

    //TODO validate cors
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("http://localhost:3000/")
                .allowedMethods("PUT", "DELETE", "POST", "GET")
                .allowCredentials(true).maxAge(3600);
    }
}
