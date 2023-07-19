package com.example.listore.repository;

import com.example.listore.models.Supplier;
import java.awt.print.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends GeneralRepository<Supplier>{
    @Query("SELECT S FROM Supplier AS S " +
            "WHERE S.name LIKE %:#{#supplier.name}%" +
            "AND S.description LIKE %:#{#supplier.description}%")
    List<Supplier> findByFilter(@Param("supplier") Supplier supplier, Pageable page);

    @Query("SELECT COUNT(S) FROM Supplier AS S " +
            "WHERE S.name LIKE %:#{#supplier.name}%" +
            "AND S.description LIKE %:#{#supplier.description}%")
    long countByFilter(@Param("supplier") Supplier supplier);
}
