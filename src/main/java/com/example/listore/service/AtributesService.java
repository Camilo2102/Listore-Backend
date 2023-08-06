package com.example.listore.service;

import com.example.listore.models.Atributes;
import com.example.listore.models.Inventory;
import com.example.listore.repository.AtributesRepository;
import com.example.listore.repository.GeneralRepository;
import org.springframework.stereotype.Service;

@Service("AtributesService")
public class AtributesService extends GeneralService<Atributes>{

    private final AtributesRepository atributesRepository;

    public AtributesService(AtributesRepository atributesRepository) {
        super(atributesRepository);
        this.atributesRepository = atributesRepository;
    }
}
