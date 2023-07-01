package com.example.listore.service;

import com.example.listore.interfaces.CRUDService;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;
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
        return Optional.empty();
    }

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    public User saveWithTransaction(User user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void delete(String id) throws Exception {

    }

    @Override
    public long count() {
        return 0;
    }
}
