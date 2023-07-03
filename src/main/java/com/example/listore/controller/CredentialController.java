package com.example.listore.controller;

import com.example.listore.constants.MessageConstants;
import com.example.listore.constants.StatusConstants;
import com.example.listore.dto.RegisterUserDTO;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import com.example.listore.service.CredentialService;
import com.example.listore.utils.EncryptUtil;
import com.example.listore.utils.TokenUtil;
import com.example.listore.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


//ANotacion necesaria para decir que es un controlador y llamar las rutas
@RestController
@RequestMapping("/auth")
@Transactional
public class CredentialController extends GeneralController<Credential> {

    private final CredentialService credentialService;
    private final UserService userService;
    @Autowired
    public CredentialController(CredentialService credentialService, UserService userService) {
        super(credentialService);
        this.credentialService = credentialService;
        this.userService = userService;
    }

    @Override
    @Hidden
    public List<Credential> getAll() throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @Override
    @Hidden
    public long getAllCount() throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @Override
    @Hidden
    public Credential getByID(String id) throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @Override
    @Hidden
    public List<Credential> getAll(int pageNumber, int pageSize) throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @Override
    public Credential update(Credential credential) throws Exception {
        Credential credentialEncrypted = credentialWithEncryptedPassword(credential);
        return credentialService.save(credentialEncrypted);
    }

    private Credential credentialWithEncryptedPassword(Credential credential) {
        String hashedPassword = EncryptUtil.encryptValue(credential.getPassword());
        credential.setPassword(hashedPassword);

        return credential;
    }


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Credential credential) throws Exception {
        Map<String, String> response = new HashMap<>();

        Optional<Credential> credentialFound = credentialService.findByUserAndMail(credential.getMail());

        if (credentialFound.isPresent()) {
            boolean state = EncryptUtil.checkValues(credential.getPassword(), credentialFound.get().getPassword());
            if (state) {
                Credential credentialData = credentialFound.get();
                User user = userService.getByCredential(credentialData);

                Map<String, String> userData = new HashMap<>();
                userData.put("id", user.getId());
                userData.put("role", String.valueOf(user.getRole()));

                String token = TokenUtil.generateToken(userData);

                response.put(StatusConstants.STATUS, StatusConstants.AUTHORIZED);
                response.put("token", token);
            }
        } else {
            throw new Exception(StatusConstants.UNAUTHORIZED);
        }

        return response;
    }


    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterUserDTO registerUserDTO) throws Exception {
        Map<String, String> response = new HashMap<>();
        response.put("message", MessageConstants.FAILED_MESSAGE);

        Credential encryptedCredential = credentialWithEncryptedPassword(registerUserDTO.getCredential());
        Credential createdCredential = credentialService.save(encryptedCredential);

        User createdUser = new User(registerUserDTO.getUser());
        createdUser.setCredential(createdCredential);
        createdUser = userService.save(createdUser);

        response.put("message", MessageConstants.SUCCESS_MESSAGE);
        return response;
    }
}
