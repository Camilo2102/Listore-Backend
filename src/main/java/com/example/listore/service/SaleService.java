package com.example.listore.service;

import com.example.listore.models.Sale;
import com.example.listore.repository.BuyRepository;
import com.example.listore.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SaleService")
public class SaleService extends GeneralService<Sale>{

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        super(saleRepository);
        this.saleRepository = saleRepository;
    }

}
