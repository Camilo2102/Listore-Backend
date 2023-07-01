package com.example.listore.config;

import com.example.listore.interceptores.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
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
    }


    /**
     * Se encarga de inicializar la ruta de auth y agregar los permisos
     * @param registry recibe el registru para asignarle los parametros de la ruta
     */
    private void initializeAuthRoute(InterceptorRegistry registry) {
        TokenHandler tokenHandler = generateTokenHandlerWithPermissions(new char[]{'A', 'B'});
        registry.addInterceptor(tokenHandler).addPathPatterns("/**").excludePathPatterns("/auth/login");
    }

    /**
     * Genera el token handler segurn los permisos ingresados
     * @param permissions un arreglo de caracteres con los permisos del usaurio
     * @return el token hanlder preparado para validar los permisos
     */
    private TokenHandler generateTokenHandlerWithPermissions(char[] permissions){
        tokenHandler.setPermissions(permissions);
        return tokenHandler.copyTokenHandler();
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
