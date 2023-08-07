package com.example.listore.repository;

import com.example.listore.models.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends GeneralRepository<Sale>{

    @Query("SELECT S FROM Sale AS S ")
    List<Sale> findByFilter(Sale sale, Pageable page);

    @Query("SELECT COUNT(S) FROM Sale AS S ")
    long countByFilter(Sale sale);
}
