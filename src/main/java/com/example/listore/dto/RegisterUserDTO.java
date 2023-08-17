package com.example.listore.dto;

import com.example.listore.models.Company;
import com.example.listore.models.Credential;
import com.example.listore.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDTO {
    private Credential credential;
    private User user;
    private Company company;
}
