package com.example.listore.service;

import com.example.listore.interfaces.CRUDService;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import com.example.listore.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserService")
public class UserService extends GeneralService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public User getByCredential(Credential credential) {
        return userRepository.findByCredential(credential);
    }
}
