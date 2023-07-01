package com.example.listore.controller;

import com.example.listore.interfaces.CRUDController;
import com.example.listore.models.User;
import com.example.listore.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//Anotacion necesaria para decir que es un controlador y llamar las rutas
@RestController
@RequestMapping("/user")
@Transactional
public class UserController extends GeneralController<User> {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        super(userService);
        this.userService = userService;
    }

}
