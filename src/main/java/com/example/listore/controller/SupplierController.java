package com.example.listore.controller;

import com.example.listore.models.Supplier;
import com.example.listore.service.SupplierService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
@Transactional
public class SupplierController extends GeneralController<Supplier> {
    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        super(supplierService);
        this.supplierService = supplierService;
    }
}
