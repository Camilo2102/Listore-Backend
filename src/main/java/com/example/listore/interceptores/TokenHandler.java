package com.example.listore.interceptores;

import com.auth0.jwt.interfaces.Claim;
import com.example.listore.constants.MessageConstants;
import com.example.listore.models.User;
import com.example.listore.service.UserService;
import com.example.listore.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.Optional;


@Component
@Setter
public class TokenHandler implements HandlerInterceptor {

    private final UserService userService;

    @Autowired
    public TokenHandler(UserService userService) {
        this.userService = userService;
    }

    private char[] permissions;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");

        Map<String, Claim> payload = TokenUtil.validateToken(token);

        char role = payload.get("role").asString().charAt(0);
        String id = payload.get("id").asString();

        if (isValidInPermissionList(role) && isValidInUserList(id, role)) {
            return true;
        }

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, MessageConstants.UNAUTHORIZED_TOKEN);
        return false;
    }


    /**
     * Valida con la base de datos que el usuario si se encuentre en el sistema y que el rol que tiene si sea el que se obtiene por el token
     *
     * @param id   id del usuario
     * @param role rol del usuario
     * @return booleano con el estado de la validacion
     * @throws Exception error en caso de no encontrarlo en el sistema
     */
    private boolean isValidInUserList(String id, char role) throws Exception {
        Optional<User> userFind = userService.findById(id);
        return userFind.isPresent() && userFind.get().getRole() == role;
    }

    /**
     * Valida con la lista de permisos que el usuairo tenga permiso para acceder al sistema
     *
     * @param role rol del usuario
     * @return el estado de la comprobacion con los permisos
     */
    private boolean isValidInPermissionList(char role) {
        for (char permission : permissions) {
            if (role == permission) {
                return true;
            }
        }
        return false;
    }

    public TokenHandler copyTokenHandler() {
        TokenHandler copy = new TokenHandler(this.userService);
        copy.setPermissions(this.permissions.clone());
        return copy;
    }

}
