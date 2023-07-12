package com.example.listore.service;

import com.example.listore.constants.MessageConstants;
import com.example.listore.dto.CredentialFilterDTO;
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
public class CredentialService extends GeneralService<Credential>{

    //Al crear una interface es necesario implementarla, en este caso la anotacion autowired se encarga de inicalizarla

    private final CredentialRepository credentialRepository;

    @Autowired
    public CredentialService(CredentialRepository credentialRepository) {
        super(credentialRepository);
        this.credentialRepository = credentialRepository;
    }

    public Optional<Credential> findByUserAndMail(String identifier){
        return credentialRepository.findByUserNameOrMail(identifier, identifier);
    }
}
