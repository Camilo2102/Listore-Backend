package com.example.listore.controller;

import com.example.listore.constants.MessageConstants;
import com.example.listore.interfaces.CRUDController;
import com.example.listore.models.Credential;
import com.example.listore.models.GeneralModel;
import com.example.listore.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador general que provee al controllador la funcionalidad basicad el crud, y las rutas establecidas en el crudController, en caso de necesitar personalizar el metodo usar @Override
 * @param <T>
 */
public abstract class GeneralController <T extends GeneralModel, K> implements CRUDController<T, K> {

    protected final GeneralService<T, K> generalService;

    @Autowired
    public GeneralController(GeneralService<T, K> generalService) {
        this.generalService = generalService;
    }

    /**
     * Obtiene todos los registros para una entity T
     * @return Lista con todos los registros
     * @throws Exception error en caso de fallo en la consulta
     */
    @Override
    public List<T> getAll() throws Exception {
        return generalService.getAll();
    }

    /**
     * Obtiene el número total de elementos en la entidad.
     *
     * @return El número total de elementos.
     * @throws Exception Si ocurre algún error al obtener el recuento.
     */
    @Override
    public long getAllCount() throws Exception {
        return generalService.count();
    }

    /**
     * Obtiene un elemento de la entidad según el ID proporcionado.
     *
     * @param id El ID del elemento a obtener.
     * @return El elemento correspondiente al ID.
     * @throws Exception Si ocurre algún error al obtener el elemento.
     */
    @Override
    public T getByID(String id) throws Exception {
        return generalService.findById(id);
    }

    /**
     * Obtiene una lista de elementos de la entidad paginados según el número de página y el tamaño de página especificados.
     *
     * @param pageNumber El número de página.
     * @param pageSize   El tamaño de página.
     * @return Una lista de elementos paginados.
     * @throws Exception Si ocurre algún error al obtener la lista paginada.
     */
    @Override
    public List<T> getAll(int pageNumber, int pageSize) throws Exception {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return generalService.getAllPageable(page);
    }

    /**
     * Permite btener todos los registros segun el filtro aplicado
     * @param k el filtro a aplicar
     * @param pageNumber el nuimero de la pagina
     * @param pageSize el tamaño de la pagina
     * @return los registros segun el filtro
     * @throws Exception en caso de no ser implementado
     */
    @Override
    public List<T> getAllByFilters(K k, int pageNumber, int pageSize) throws Exception {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return generalService.getAllByFilter(k, page);
    }

    /**
     * Cuenta los registros segun el filtro
     * @param k el filtro a aplicar
     * @return el nuimero de registrso con ese filtro
     * @throws Exception en caso de no ser implementado
     */
    @Override
    public long countAllByFilters(K k) throws Exception {
        return generalService.countByFilter(k);
    }

    /**
     * Crea un nuevo elemento en la entidad.
     *
     * @param t El elemento a crear.
     * @return El elemento creado.
     * @throws Exception Si ocurre algún error al crear el elemento.
     */
    @Override
    public T create(T t) throws Exception {
        return generalService.save(t);
    }

    /**
     * Actualiza un elemento existente en la entidad.
     *
     * @param t El elemento a actualizar.
     * @return El elemento actualizado.
     * @throws Exception Si ocurre algún error al actualizar el elemento.
     */
    @Override
    public T update(T t) throws Exception {
        T tFound = generalService.findById(t.getId());
        return generalService.save(tFound);
    }

    /**
     * Elimina un elemento de la entidad según el ID proporcionado.
     *
     * @param id El ID del elemento a eliminar.
     * @return Un mapa con un mensaje de éxito si se elimina correctamente.
     * @throws Exception Si ocurre algún error al eliminar el elemento.
     */
    @Override
    public Map<String, String> delete(String id) throws Exception {
        Map<String, String> response = new HashMap<>();
        response.put("message", MessageConstants.FAILED_MESSAGE);

        try {
            generalService.delete(id);
            response.put("message", MessageConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            throw new Exception(MessageConstants.FAILED_MESSAGE);
        }

        return response;
    }
}
