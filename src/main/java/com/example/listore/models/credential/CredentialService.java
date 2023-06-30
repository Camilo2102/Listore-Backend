package com.example.listore.models.credential;

import com.example.listore.constants.MessageConstants;
import com.example.listore.models.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Definir anotacion @Service para poder usar el autowired
@Service("CredentialService")
public class CredentialService implements CRUDService<Credential>{

    //Al crear una interface es necesario implementarla, en este caso la anotacion autowired se encarga de inicalizarla
    @Autowired
    private CredentialRepository credentialRepository;
    @Override
    public List<Credential> getAll() throws Exception {
        return null;
    }

    @Override
    public List<Credential> getAllPageable(Pageable page) throws Exception {
        return credentialRepository.findAll(page);
    }

    @Override
    public Optional<Credential> findById(String id) throws Exception {
        return credentialRepository.findById(id);
    }

    @Override
    public Credential save(Credential credential) throws Exception {
        try {
            return credentialRepository.save(credential);
        }catch (Exception e) {
            throw new Exception(MessageConstants.DUPLICATED_MESSAGE);
        }

    }

    @Override
    public void delete(String id) throws Exception {
        credentialRepository.deleteById(id);
    }

    @Override
    public long count() {
        return credentialRepository.count();
    }

    public Optional<Credential> findByUserAndMail(String identifier){
        return credentialRepository.findByUserOrMail(identifier, identifier);
    }
}
