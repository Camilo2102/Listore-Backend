package com.example.listore.interfaces;

import com.example.listore.constants.RoutesConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Interface que genera los metodos basicos del crud y sus respectivas rutas
 * @param <T> Clase a la cual se le va a generar el crud
 */
@RestController
public interface CRUDController<T> {
    /**
     * Ruta para obtener todos los registros de una tabla
     * @return lista con todos los registros
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @GetMapping(RoutesConstants.GET_ALL_ROUTE)
    public List<T> getAll() throws Exception;

    /**
     * Ruta para obtener la cantidad de registros total de una tabla
     * @return el total de registros
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @GetMapping(RoutesConstants.GET_ALL_COUNT_ROUTE)
    public long getAllCount() throws Exception;

    /**
     * !! RECOMENDADO ruta para  obtener los registros con paginacion
     * @param pageNumber numero de la pagina
     * @param pageSize cantidad de datos
     * @return Lista con los datos de la pagina ingresada y el numero de datos escogido
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @GetMapping(RoutesConstants.GET_ALL_BY_PAGE_ROUTE)
    public List<T> getAll(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws Exception;

    /**
     * RUta que permite obtener todos los registros paginados y con el filtro arreglado
     * @param k el filtro a aplicar
     * @param pageNumber el nuimero de la pagina
     * @param pageSize el tamaño de la pagina
     * @return la lista con los datos
     * @throws Exception tira execpcion en lugar de no ser implementado
     */
    @PostMapping(RoutesConstants.GET_ALL_BY_FILTERS)
    public List<T> getAllByFilters(@RequestBody T t, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws Exception;

    /**
     * RUta que permite obtener la cantidad de  registros paginados y con el filtro arreglado
     * @param k el filtro a aplicar
     * @return la cantidad de registros
     * @throws Exception tira execpcion en lugar de no ser implementado
     */
    @PostMapping(RoutesConstants.COUNT_ALL_BY_FILTERS)
    public long countAllByFilters(@RequestBody T t) throws Exception;

    /**
     * Obtiene un elemento por id
     * @param id id del elemento a buscar
     * @return el elemento encontrado
     * @throws Exception en caso de no encutnrar un elemento fallará
     */
    @GetMapping(RoutesConstants.GET_BY_ID_ROUTE)
    public T getByID(@RequestParam("id") String id) throws Exception;

    /**
     * ruta para ungresar un nuevo registro
     * @param t objeto de la clase que se recibe en el cuerpo de la peticion
     * @return el objeto creado
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @PostMapping(RoutesConstants.CREATE_ROUTE)
    public T create(@RequestBody T t) throws Exception;

    /**
     * ruta para actualizar un registro
     * @param t objeto de la clase que se recibe en el cuerpo de la peticion
     * @return el objeto actualziado
     * @throws Exception n caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @PutMapping(RoutesConstants.UPDATE_ROUTE)
    public T update(@RequestBody T t) throws Exception;

    /**
     * ruta para la eliminacion de un registro
     * @param id el id del registro a eliminar
     * @return un map(json) con el mensaje de que fue realizado con exito la eliminación
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @DeleteMapping(RoutesConstants.DELETE_ROUTE)
    public Map<String, String> delete(@RequestParam("id") String id) throws Exception;

    /**
     *
     * @param t
     * @return
     * @throws Exception
     */
    @PostMapping(RoutesConstants.SAVEALL_ROUTE)
    public Map<String, String> saveAll(@RequestBody List<T> t) throws  Exception;
}
