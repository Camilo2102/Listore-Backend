package com.example.listore.service;

import com.example.listore.models.Spent;
import com.example.listore.repository.GeneralRepository;
import com.example.listore.repository.SpentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SpentService")
public class SpentService extends GeneralService<Spent>{

    private final SpentRepository spentRepository;

    @Autowired
    public SpentService(SpentRepository spentRepository) {
        super(spentRepository);
        this.spentRepository = spentRepository;
    }

}
