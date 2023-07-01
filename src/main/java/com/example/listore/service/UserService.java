package com.example.listore.service;

import com.example.listore.interfaces.CRUDService;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import com.example.listore.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserService")
public class UserService implements CRUDService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public List<User> getAllPageable(Pageable page) throws Exception {
        return null;
    }

    @Override
    public Optional<User> findById(String id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public long count() {
        return 0;
    }

    public User getByCredential(Credential credential) {
        return userRepository.findByCredential(credential);
    }
}
