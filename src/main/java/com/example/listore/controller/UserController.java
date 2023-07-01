package com.example.listore.controller;

import com.example.listore.interfaces.CRUDController;
import com.example.listore.models.User;
import com.example.listore.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//Anotacion necesaria para decir que es un controlador y llamar las rutas
@RestController
@RequestMapping("/user")
public class UserController implements CRUDController<User> {
    private UserService userService;

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public long getAllCount() throws Exception {
        return 0;
    }

    @Override
    public List<User> getAll(int pageNumber, int pageSize) throws Exception {
        return null;
    }

    @Override
    public User insert(User user) throws Exception {
        return null;
    }

    @Override
    public User update(User user) throws Exception {
        return null;
    }

    @Override
    public Map<String, String> delete(String id) throws Exception {
        return null;
    }
}
