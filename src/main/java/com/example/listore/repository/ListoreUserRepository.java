package com.example.listore.repository;

import com.example.listore.models.Credential;
import com.example.listore.models.ListoreUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListoreUserRepository extends GeneralRepository<ListoreUser> {

    @Query("SELECT U FROM ListoreUser AS U WHERE U.role NOT IN('C', 'M') AND U.active NOT IN ('N')" +
            "AND (:#{#user.name} is null or U.name LIKE  %:#{#user.name}%) " +
            "AND (:#{#user.role} is null or U.role LIKE %:#{#user.role}%) " +
            "AND U.company.id LIKE %:#{#user.company.id}% ")
    List<ListoreUser> findByFilter(
            @Param("user") ListoreUser user,
            Pageable page
    );

    @Query("SELECT COUNT(U) FROM ListoreUser AS U WHERE U.role NOT IN('C', 'M') AND U.active NOT IN ('N')" +
            "AND U.name LIKE  %:#{#user.name}% " +
            "AND U.role LIKE %:#{#user.role}% " +
            "AND U.company.id LIKE %:#{#user.company.id}% ")
    long countByFilter(
            @Param("user") ListoreUser user
    );

    @Query("SELECT u FROM ListoreUser u WHERE u.credential = :credential")
    public ListoreUser findByCredential(@Param("credential") Credential credential);
}
