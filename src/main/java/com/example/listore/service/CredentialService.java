package com.example.listore.service;

import com.example.listore.constants.MessageConstants;
import com.example.listore.interfaces.CRUDService;
import com.example.listore.models.Credential;
import com.example.listore.repository.CredentialRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Definir anotacion @Service para poder usar el autowired
@Service("CredentialService")
@Transactional
public class CredentialService implements CRUDService<Credential>{

    //Al crear una interface es necesario implementarla, en este caso la anotacion autowired se encarga de inicalizarla
    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Credential> getAll() throws Exception {
        return (List<Credential>) credentialRepository.findAll();
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

    public Credential saveWithTransaction(Credential credential) {
        entityManager.persist(credential);
        return credential;
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
        return credentialRepository.findByUserNameOrMail(identifier, identifier);
    }
}
