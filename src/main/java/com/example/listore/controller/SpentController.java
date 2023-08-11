package com.example.listore.controller;

import com.example.listore.models.Spent;
import com.example.listore.service.SaleService;
import com.example.listore.service.SpentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spent")
@Transactional
public class SpentController extends GeneralController<Spent>{

    private final SpentService spentService;

    public SpentController(SpentService spentService) {
        super(spentService);
        this.spentService = spentService;
    }

}
