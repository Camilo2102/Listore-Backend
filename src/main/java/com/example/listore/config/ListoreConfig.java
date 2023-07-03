package com.example.listore.config;

import com.example.listore.interceptores.TokenHandler;
import com.example.listore.models.Credential;
import com.example.listore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@EnableWebMvc
public class ListoreConfig implements WebMvcConfigurer {

    private final TokenHandler tokenHandler;

    @Autowired
    public ListoreConfig(TokenHandler tokenHandler) {
        this.tokenHandler = tokenHandler;
    }

    /**
     * Agrega validaciones intermedias para las rutas especificacdas
     * @param registry registro de interceptores
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        initializeAuthRoute(registry);
        initializeUserRoute(registry);
    }


    /**
     * Se encarga de inicializar la ruta de auth y agregar los permisos
     * @param registry recibe el registru para asignarle los parametros de la ruta
     */
    private void initializeAuthRoute(InterceptorRegistry registry) {
        this.tokenHandler.addToPermissionListByPath("auth", new char[]{'A', 'B'});
        registry.addInterceptor(tokenHandler).addPathPatterns("/auth/**").excludePathPatterns("/auth/login");
    }

    private void initializeUserRoute(InterceptorRegistry registry) {
        this.tokenHandler.addToPermissionListByPath("user", new char[]{'X', 'Z'});
        registry.addInterceptor(tokenHandler).addPathPatterns("/user/**");
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
