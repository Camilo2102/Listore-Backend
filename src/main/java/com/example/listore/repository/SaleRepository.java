package com.example.listore.repository;

import com.example.listore.models.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends GeneralRepository<Sale>{

    @Query("SELECT S FROM Sale AS S " +
            "WHERE (:#{#sale.user.id} is null or S.user.id = :#{#sale.user.id}) " +
            "AND (:#{#sale.initialDate} is null or S.saleDate > :#{#sale.initialDate}) " +
            "AND (:#{#sale.finalDate} is null or S.saleDate < :#{#sale.finalDate})  " +
            "AND (:#{#sale.initialDate} is null or S.saleDate > :#{#sale.initialDate}) " +
            "ORDER BY S.saleDate DESC ")
    List<Sale> findByFilter(Sale sale, Pageable page);


    @Query("SELECT COUNT(S) FROM Sale AS S ")
    long countByFilter(Sale sale);
}
