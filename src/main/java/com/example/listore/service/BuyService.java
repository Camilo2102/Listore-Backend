package com.example.listore.service;

import com.example.listore.models.Buy;
import com.example.listore.repository.BuyRepository;
import com.example.listore.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BuyService")
public class BuyService extends GeneralService<Buy>{

    private final BuyRepository buyRepository;

    @Autowired
    public BuyService(BuyRepository buyRepository) {
        super(buyRepository);
        this.buyRepository = buyRepository;
    }

}
