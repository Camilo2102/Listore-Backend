package com.example.listore.repository;

import com.example.listore.dto.UserFilterDTO;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GeneralRepository<User> {

    @Query("SELECT U FROM User AS U WHERE U.role NOT IN('C') " +
            "AND U.name LIKE  %:#{#userFilterDTO.name}% " +
            "AND U.role LIKE %:#{#userFilterDTO.role}% " +
            "AND U.company.id LIKE %:#{#userFilterDTO.companyId}% ")
    List<User> findByFilter(
            @Param("userFilterDTO") UserFilterDTO userFilterDTO,
            Pageable page
    );



    @Query("SELECT u FROM User u WHERE u.credential = :credential")
    public User findByCredential(@Param("credential") Credential credential);
}
