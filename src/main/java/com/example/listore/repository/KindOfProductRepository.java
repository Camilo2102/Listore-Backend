package com.example.listore.repository;

import com.example.listore.models.KindOfProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KindOfProductRepository extends GeneralRepository<KindOfProduct> {

    @Override
    @Query("SELECT K FROM KindOfProduct K")
    List<KindOfProduct> findByFilter(KindOfProduct kindOfProduct, Pageable page);

    @Override
    @Query("SELECT count(K) FROM KindOfProduct K")
    long countByFilter(KindOfProduct kindOfProduct);
}
