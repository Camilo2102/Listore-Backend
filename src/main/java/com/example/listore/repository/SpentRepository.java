package com.example.listore.repository;

import com.example.listore.models.Spent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpentRepository extends GeneralRepository<Spent>{

    @Query("SELECT S FROM Spent AS S ")
    List<Spent> findByFilter(Spent spent, Pageable page);

    @Query("SELECT COUNT(S) FROM Spent AS S ")
    long countByFilter(Spent spent);
}
