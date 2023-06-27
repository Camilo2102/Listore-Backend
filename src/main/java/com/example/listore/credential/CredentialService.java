package com.example.listore.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Definir anotacion @Service para poder usar el autowired
@Service("CredentialService")
public class CredentialService {

    //Al crear una interface es necesario implementarla, en este caso la anotacion autowired se encarga de inicalizarla
    @Autowired
    private CredentialRepository credentialRepository;

    /**
     * Eliminar metodo, solo muestra !!
     * @return Lista con el total de credenciales
     */
    public List<Credential> getAllCredentials() {
        return (List<Credential>) credentialRepository.findAll();
    }

    public Credential saveCredentials(Credential credential) throws Exception {
        try {
            return credentialRepository.save(credential);
        }catch (Error e) {
            throw new Exception("Datos duplicados");
        }
    }

    public Optional<Credential> findByUserAndMail(String identifier){
        return credentialRepository.findByUserOrMail(identifier, identifier);
    }
}
