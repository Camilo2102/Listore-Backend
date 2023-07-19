package com.example.listore.service;

import com.example.listore.models.Supplier;
import com.example.listore.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SupplierService")
public class SupplierService extends GeneralService<Supplier> {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        super(supplierRepository);
        this.supplierRepository = supplierRepository;
    }
}
