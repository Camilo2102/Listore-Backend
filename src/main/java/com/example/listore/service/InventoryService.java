package com.example.listore.service;

import com.example.listore.models.Inventory;
import com.example.listore.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InventoryService")
public class InventoryService extends GeneralService<Inventory> {

    private final InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        super(inventoryRepository);
        this.inventoryRepository = inventoryRepository;
    }
    //*Devuelve todos los inventraios de la base de datos
    public Iterable<Inventory> listarTodosLosInventraios(){
        return inventoryRepository.findAll();
    }
}
