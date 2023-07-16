package com.example.listore.controller;

import com.example.listore.models.Inventory;
import com.example.listore.service.InventoryService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@Transactional
public class InventoryController extends GeneralController<Inventory>{

    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        super(inventoryService);
        this.inventoryService = inventoryService;
    }
}
