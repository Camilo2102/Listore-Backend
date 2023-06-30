package com.example.listore.credential;

import com.example.listore.constants.MessageConstants;
import com.example.listore.constants.StatusConstants;
import com.example.listore.models.CRUDController;
import com.example.listore.utils.EncryptUtil;
import com.example.listore.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//ANotacion necesaria para decir que es un controlador y llamar las rutas
@RestController
@RequestMapping("/auth")
public class CredentialController implements CRUDController<Credential> {

    @Autowired
    private CredentialService credentialService;

    @Override
    public List<Credential> getAll() throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @Override
    public long getAllCount() {
        return credentialService.count();
    }

    @Override
    public List<Credential> getAll(int pageNumber, int pageSize) throws Exception {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return credentialService.getAllPageable(page);
    }



    @Override
    public Credential insert(Credential credential) throws Exception {
        Credential credentialEncrypted = credentialWithEncryptedPassword(credential);
        return credentialService.save(credentialEncrypted);
    }

    @Override
    public Credential update(Credential credential) throws Exception {
        Credential credentialEncrypted = credentialWithEncryptedPassword(credential);
        return credentialService.save(credentialEncrypted);
    }

    private Credential credentialWithEncryptedPassword(Credential credential){
        String hashedPassword = EncryptUtil.encryptValue(credential.getPassword());
        credential.setPassword(hashedPassword);

        return credential;
    }

    @Override
    public Map<String, String> delete(int id) throws Exception {
        throw new Exception(MessageConstants.NOT_IMPLEMENTED_ROUTE);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Credential credential) throws Exception {
        Map<String, String> response = new HashMap<>();

        Optional<Credential> credentialFound = credentialService.findByUserAndMail(credential.getMail());

        if (credentialFound.isPresent()) {
            boolean state = EncryptUtil.checkValues(credential.getPassword(), credentialFound.get().getPassword());
            if (state) {
                Map<String, String> userData = new HashMap<>();
                userData.put("user", credentialFound.get().getUser());
                userData.put("id", credentialFound.get().getId());

                String token = TokenUtil.generateToken(userData);

                response.put(StatusConstants.STATUS, StatusConstants.AUTHORIZED);
                response.put("token", token);
            }
        } else {
            throw new Exception(StatusConstants.UNAUTHORIZED);
        }

        return response;
    }
}
