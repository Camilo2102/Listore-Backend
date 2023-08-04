package com.example.listore.controller;

import com.example.listore.models.Atributes;
import com.example.listore.service.AtributesService;
import com.example.listore.service.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atributes")
@Transactional
public class AtributesController extends GeneralController<Atributes>{

    private final AtributesService atributesService;

    public AtributesController(AtributesService atributesService) {
        super(atributesService);
        this.atributesService = atributesService;
    }
}
