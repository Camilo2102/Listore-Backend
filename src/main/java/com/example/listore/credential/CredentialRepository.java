package com.example.listore.credential;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
        // extiende de CRUDRepository, en los parametros se pone el modelo, y en el siguiente parametro el tipo del id
public interface CredentialRepository extends CrudRepository<Credential, String> {

    public Optional<Credential> findByUserOrMail(String user, String mail);
}
