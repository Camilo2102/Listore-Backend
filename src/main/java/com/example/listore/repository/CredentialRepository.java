package com.example.listore.repository;

import com.example.listore.dto.CredentialFilterDTO;
import com.example.listore.models.Credential;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// extiende de CRUDRepository, en los parametros se pone el modelo, y en el siguiente parametro el tipo del id
public interface CredentialRepository extends GeneralRepository<Credential, CredentialFilterDTO> {

    public Optional<Credential> findByUserNameOrMail(String user, String mail);

}
