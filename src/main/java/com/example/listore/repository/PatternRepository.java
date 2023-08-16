package com.example.listore.repository;

import com.example.listore.models.Pattern;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatternRepository extends GeneralRepository<Pattern> {

    @Query("SELECT P FROM Pattern AS P ")
    List<Pattern> findByFilter(Pattern pattern, Pageable page);

    @Query("SELECT COUNT(P) FROM Pattern AS P ")
    long countByFilter(Pattern pattern);
}
