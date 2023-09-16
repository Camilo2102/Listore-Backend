package com.example.listore.repository;

import com.example.listore.models.Atributes;
import com.example.listore.models.Buy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends GeneralRepository<Buy>{

    @Query("SELECT B FROM Buy AS B " +
            "INNER JOIN B.user AS U " +
            "INNER JOIN U.company AS C " +
            "WHERE (:#{#buy.user.id} is null or U.id = :#{#buy.user.id}) " +
            "AND (:#{#buy.amount} is null or B.amount = :#{#buy.amount}) " +
            "AND (:#{#buy.price} is null or B.price = :#{#buy.price}) " +
            "AND (:#{#buy.user.company.id} is null or C.id = :#{#buy.user.company.id}) " +
            "AND (:#{#buy.initialDate} is null or B.buyDate > :#{#buy.initialDate}) " +
            "AND (:#{#buy.finalDate} is null or B.buyDate < :#{#buy.finalDate})  ")
    List<Buy> findByFilter(Buy buy, Pageable page);

    @Query("SELECT COUNT(B) FROM Buy AS B ")
    long countByFilter(Buy buy);
}
