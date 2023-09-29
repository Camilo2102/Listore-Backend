package com.example.listore.repository;

import com.example.listore.models.Sale;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends GeneralRepository<Sale>{

    @Query("SELECT S FROM Sale AS S " +
            "INNER JOIN S.user AS U " +
            "INNER JOIN U.company AS C " +
            "WHERE (:#{#sale.user.id} is null or U.id = :#{#sale.user.id}) " +
            "AND (:#{#sale.user.company.id} is null or C.id = :#{#sale.user.company.id}) " +
            "AND (:#{#sale.unitaryValue} is null or S.unitaryValue = :#{#sale.unitaryValue}) " +
            "AND (:#{#sale.amount} is null or S.amount = :#{#sale.amount}) " +
            "AND (cast(:#{#sale.initialDate} as date) is null or S.saleDate > :#{#sale.initialDate}) " +
            "AND (cast(:#{#sale.finalDate} as date) is null or S.saleDate < :#{#sale.finalDate}) " +
            "ORDER BY S.saleDate DESC ")
    List<Sale> findByFilter(Sale sale, Pageable page);




    @Query("SELECT COUNT(S) FROM Sale AS S ")
    long countByFilter(Sale sale);
}
