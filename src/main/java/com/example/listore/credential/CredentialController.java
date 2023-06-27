package com.example.listore.credential;

import com.example.listore.utils.EncryptUtil;
import com.example.listore.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//ANotacion necesaria para decir que es un controlador y llamar las rutas
@RestController
public class CredentialController {

    //endpoint base
    private final String BASEURL = "/auth";

    @Autowired
    private CredentialService credentialService;

    @GetMapping(BASEURL)
    public List<Credential> getAllCredentials() {
        return credentialService.getAllCredentials();
    }

    @PostMapping(BASEURL + "/insert")
    public Credential saveCredential(@RequestBody Credential credential) throws Exception {
        String hashedPassword = EncryptUtil.encryptValue(credential.getPassword());
        credential.setPassword(hashedPassword);

        return credentialService.saveCredentials(credential);
    }

    @PostMapping(BASEURL + "/login")
    public Map<String, String> login(@RequestBody Credential credential) throws Exception {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Unauthorized");

        Optional<Credential> credentialFound = credentialService.findByUserAndMail(credential.getMail());

        if (credentialFound.isPresent()) {
            boolean state = EncryptUtil.checkValues(credential.getPassword(), credentialFound.get().getPassword());
            if (state) {
                Map<String, String> userData = new HashMap<>();
                userData.put("user", credentialFound.get().getUser());
                userData.put("id", credentialFound.get().getId());

                String token = TokenUtil.generateToken(userData);

                response.put("status", "Authorized");
                response.put("token", token);
            }
        }

        return response;
    }
}
