package com.example.listore.repository;

import com.example.listore.models.Atributes;
import com.example.listore.models.Supplier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends GeneralRepository<Supplier>{
    @Query("SELECT S FROM Supplier AS S " +
            "WHERE S.name LIKE %:#{#supplier.name}%" +
            "AND S.description LIKE %:#{#supplier.description}% " +
            "AND S.inventory.id =:#{#supplier.inventory.id}")
    List<Supplier> findByFilter(@Param("supplier") Supplier supplier, Pageable page);

    @Query("SELECT COUNT(S) FROM Supplier AS S " +
            "WHERE S.name LIKE %:#{#supplier.name}%" +
            "AND S.description LIKE %:#{#supplier.description}%" +
            "AND S.inventory.id =:#{#supplier.inventory.id}")
    long countByFilter(@Param("supplier") Supplier supplier);




}
