package com.example.listore.repository;

import com.example.listore.models.Credential;
import com.example.listore.models.GeneralModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio general que permite las peticiones basicas del crud
 * @param <T> clase que debe extender de general model, debe ser una entity
 */
@Repository
public interface GeneralRepository<T extends GeneralModel> extends CrudRepository<T, String> {
    public List<T> findAll(Pageable page);
}
