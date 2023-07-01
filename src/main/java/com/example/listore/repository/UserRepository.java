package com.example.listore.repository;

import com.example.listore.models.Credential;
import com.example.listore.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.credential = :credential")
    public User findByCredential(@Param("credential") Credential credential);
}
