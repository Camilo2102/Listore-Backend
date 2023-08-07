package com.example.listore.controller;

import com.example.listore.models.Buy;
import com.example.listore.service.BuyService;
import com.example.listore.service.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
@Transactional
public class BuyController extends GeneralController<Buy>{

    private final BuyService buyService;

    public BuyController(BuyService buyService) {
        super(buyService);
        this.buyService = buyService;
    }
}
