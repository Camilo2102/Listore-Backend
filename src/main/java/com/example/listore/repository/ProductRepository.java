package com.example.listore.repository;

import com.example.listore.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends GeneralRepository<Product>{

    @Query("SELECT P FROM Product AS P WHERE P.inventory.id LIKE %:#{#product.inventory.id} ")

    List<Product> findByFilter(
            @Param("product") Product product,
            Pageable page
    );

    @Query("SELECT COUNT(P) FROM Product AS P WHERE P.inventory.id LIKE %:#{#product.inventory.id}")
    long countByFilter(
            @Param("product") Product product);
}
