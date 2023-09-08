package com.example.listore.repository;

import com.example.listore.models.Atributes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtributesRepository extends GeneralRepository<Atributes>{
    @Query("SELECT A FROM Atributes As A " +
            "WHERE ( :#{#atributes  .name} is null or A.name LIKE %:#{#atributes.name}%) " +
            "AND A.pattern.id = :#{#atributes.pattern.id}")
    List<Atributes> findByFilter(@Param("atributes") Atributes atributes, Pageable page);

    @Query("SELECT COUNT(A) FROM Atributes As A " +
            "WHERE A.name LIKE %:#{#atributes.name}%" +
            "AND A.pattern.id =:#{#atributes.pattern.id}")
    long countByFilter(@Param("atributes") Atributes atributes);
}
