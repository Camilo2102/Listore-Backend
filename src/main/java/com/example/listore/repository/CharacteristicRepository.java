package com.example.listore.repository;

import com.example.listore.models.Characteristic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends GeneralRepository<Characteristic> {

    @Modifying
    @Query("DELETE FROM Characteristic C WHERE C.kindOfProduct.id = :id")
    void deleteAllById(String id);
}
