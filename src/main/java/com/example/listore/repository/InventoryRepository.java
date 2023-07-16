package com.example.listore.repository;

import com.example.listore.models.Inventory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends GeneralRepository<Inventory>{


    @Query("SELECT I FROM Inventory AS I " +
            "WHERE I.category LIKE %:#{#inventory.category}% " +
            "AND I.description LIKE %:#{#inventory.description}% " +
            "AND I.name LIKE %:#{#inventory.name}%")
    List<Inventory> findByFilter(@Param("inventory") Inventory inventory, Pageable page);

    @Override
    @Query("SELECT count(I) FROM Inventory AS I " +
            "WHERE I.category LIKE %:#{#inventory.category}% " +
            "AND I.description LIKE %:#{#inventory.description}% " +
            "AND I.name LIKE %:#{#inventory.name}%")
    long countByFilter(
            @Param("inventory") Inventory inventory);


}
