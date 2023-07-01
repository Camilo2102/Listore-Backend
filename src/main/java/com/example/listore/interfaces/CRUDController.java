package com.example.listore.interfaces;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/getAll")
    public List<T> getAll() throws Exception;

    /**
     * Ruta para obtener la cantidad de registros total de una tabla
     * @return el total de registros
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @GetMapping("/getAllCount")
    public long getAllCount() throws Exception;

    /**
     * !! RECOMENDADO ruta para  obtener los registros con paginacion
     * @param pageNumber numero de la pagina
     * @param pageSize cantidad de datos
     * @return Lista con los datos de la pagina ingresada y el numero de datos escogido
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @GetMapping("/getAllByPage")
    public List<T> getAll(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws Exception;

    /**
     * ruta para ungresar un nuevo registro
     * @param t objeto de la clase que se recibe en el cuerpo de la peticion
     * @return el objeto creado
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @PostMapping("/insert")
    public T insert(@RequestBody T t) throws Exception;

    /**
     * ruta para actualizar un registro
     * @param t objeto de la clase que se recibe en el cuerpo de la peticion
     * @return el objeto actualziado
     * @throws Exception n caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @PutMapping("/update")
    public T update(@RequestBody T t) throws Exception;

    /**
     * ruta para la eliminacion de un registro
     * @param id el id del registro a eliminar
     * @return un map(json) con el mensaje de que fue realizado con exito la eliminación
     * @throws Exception en caso de no ser necesario agregar thorws new exeption para controlar su uso
     */
    @DeleteMapping("/delete")
    public Map<String, String> delete(@RequestParam("id") String id) throws Exception;

}
