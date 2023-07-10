package com.example.listore.service;

import com.example.listore.constants.MessageConstants;
import com.example.listore.interfaces.CRUDService;
import com.example.listore.models.GeneralModel;
import com.example.listore.models.User;
import com.example.listore.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que cuenta con todos los metodos basicos del crud implementados y listos para su uso en un controlador que extienda de generalControler
 * @param <T> Clase que extienda de general model y que sea una entity para poder establecer el repositorio
 */
@Service
public abstract class GeneralService<T extends GeneralModel, K> implements CRUDService<T, K> {

    /**
     * Repositorio general, para tener los datos basicos del crud
     */
    protected final GeneralRepository<T, K> generalRepository;

    @Autowired
    public GeneralService(GeneralRepository<T, K> generalRepository) {
        this.generalRepository = generalRepository;
    }

    /**
     * Obtiene todos los datos de la entity T
     * @return una lista con todos los registros de T
     * @throws Exception error en caso de que falle la peticion
     */
    @Override
    public List<T> getAll() throws Exception {
        return (List<T>) generalRepository.findAll();
    }

    /**
     * Obtiene todos los datos de la entity T teniendo en cuenta el paginado
     * @return una lista con todos los registros de T dentro del paginado
     * @throws Exception error en caso de que falle la peticion
     */
    @Override
    public List<T> getAllPageable(Pageable page) throws Exception {
        return generalRepository.findAll(page);
    }

    /**
     * Obtiene todos los registros segun el filtro
     * @param k el filtro a aplicar
     * @param page la cantidad de registros
     * @return la lista de los filtrso
     */
    @Override
    public List<T> getAllByFilter(K k, Pageable page) {
        return generalRepository.findByFilter(k, page);
    }

    /**
     * Obtiene la cantidad de registros apra un filtro
     * @param k el filtro a aplicar
     * @return el nuymero ed registrsos del filtro
     */
    @Override
    public long countByFilter(K k) {
        return generalRepository.countByFilter(k);
    }

    /**
     * Obtiene un elemento por el id que se registro
     * @param id id por el cual buscar el registro
     * @return un optional que contiene el objeto
     * @throws Exception en caso de no encontrarse tira un error para indicar que no se econtró
     */
    @Override
    public T findById(String id) throws Exception {
        Optional<T> t = generalRepository.findById(id);
        if(t.isEmpty()){
            throw new Exception(MessageConstants.EMPTY_MESSAGE);
        }
        return t.get();
    }

    /**
     * Guarda un registro T
     * @param t el objeto a guardar
     * @return el objeto que se guardo
     * @throws Exception en caso de obtener un dato duplicado o que no cumpla con las condiciones del registro lanza la excepcion
     */
    @Override
    public T save(T t) throws Exception {
        try {
            return generalRepository.save(t);
        }catch (Exception e){
            throw new Exception(MessageConstants.DUPLICATED_MESSAGE);
        }
    }

    /**
     * Elimina el registro en base al id ingresado
     * @param id id dado para seleccionar el registro a eliminar
     * @throws Exception en caso de que no se pueda eliminar envia un mensaje
     */
    @Override
    public void delete(String id) throws Exception {
        try {
            generalRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception(MessageConstants.FAILED_MESSAGE);
        }

    }

    /**
     * Cuenta la candidad de registros totales de una tabla
     * @return el total de registros
     */
    @Override
    public long count() {
        return generalRepository.count();
    }
}
