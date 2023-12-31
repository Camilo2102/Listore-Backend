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

    @Query("SELECT B FROM Buy AS B "
    +"WHERE (B.user.id LIKE %:#{#buy.user.id}%) " +
            "AND (:#{#buy.initialDate} is null or B.buyDate > :#{#buy.initialDate}) " +
            "AND (:#{#buy.finalDate} is null or B.buyDate < :#{#buy.finalDate})  ")
    List<Buy> findByFilter(Buy buy, Pageable page);

    @Query("SELECT COUNT(B) FROM Buy AS B ")
    long countByFilter(Buy buy);
}
