package com.example.listore.controller;

import com.example.listore.models.Sale;
import com.example.listore.service.BuyService;
import com.example.listore.service.SaleService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@Transactional
public class SaleController extends GeneralController<Sale>{

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        super(saleService);
        this.saleService = saleService;
    }

}
