package com.example.listore.repository;

import com.example.listore.models.Spent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpentRepository extends GeneralRepository<Spent>{

    @Query("SELECT S FROM Spent AS S "+
            "INNER JOIN S.user AS U " +
            "INNER JOIN U.company AS C " +
            "WHERE (:#{#spent.user.id} is null or U.id = :#{#spent.user.id}) " +
            "AND (:#{#spent.price} is null or S.price = :#{#spent.price}) " +
            "AND (:#{#spent.user.company.id} is null or C.id = :#{#spent.user.company.id}) " +
            "AND (cast(:#{#spent.initialDate}  as date) is null or S.spentDate > :#{#spent.initialDate}) " +
            "AND (cast(:#{#spent.finalDate}  as date) is null or S.spentDate < :#{#spent.finalDate})  "
    )
    List<Spent> findByFilter(Spent spent, Pageable page);

    @Query("SELECT COUNT(S) FROM Spent AS S ")
    long countByFilter(Spent spent);
}
