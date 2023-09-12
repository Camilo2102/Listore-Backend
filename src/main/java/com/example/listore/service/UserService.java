package com.example.listore.service;

import com.example.listore.models.Credential;
import com.example.listore.models.ListoreUser;
import com.example.listore.repository.ListoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService extends GeneralService<ListoreUser> {
    private final ListoreUserRepository userRepository;

    @Autowired
    public UserService(ListoreUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public ListoreUser getByCredential(Credential credential) {
        return userRepository.findByCredential(credential);
    }

}
