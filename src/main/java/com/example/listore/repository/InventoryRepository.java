package com.example.listore.repository;

import com.example.listore.dto.InventoryFilterDTO;
import com.example.listore.models.Inventory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends GeneralRepository<Inventory, InventoryFilterDTO>{


    @Query("SELECT I FROM Inventory AS I " +
            "WHERE I.category LIKE %:#{#inventoryFilterDTO.category}% " +
            "AND I.description LIKE %:#{#inventoryFilterDTO.description}% " +
            "AND I.name LIKE %:#{#inventoryFilterDTO.name}%")
    List<Inventory> findByFilter(@Param("inventoryFilterDTO") InventoryFilterDTO inventoryFilterDTO, Pageable page);

    @Override
    @Query("SELECT count(I) FROM Inventory AS I " +
            "WHERE I.category LIKE %:#{#inventoryFilterDTO.category}% " +
            "AND I.description LIKE %:#{#inventoryFilterDTO.description}% " +
            "AND I.name LIKE %:#{#inventoryFilterDTO.name}%")
    long countByFilter(
            @Param("inventoryFilterDTO") InventoryFilterDTO inventoryFilterDTO);


}
