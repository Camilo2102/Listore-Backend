package com.example.listore.service;

import com.example.listore.dto.UserFilterDTO;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import com.example.listore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<User> getAllByFilter(UserFilterDTO userFilterDTO, Pageable page) {
        return userRepository.findByFilter(userFilterDTO, page);
    }
}
