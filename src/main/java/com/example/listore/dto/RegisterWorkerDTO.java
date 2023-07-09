package com.example.listore.dto;

import com.example.listore.models.Credential;
import com.example.listore.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterWorkerDTO {
    private User user;
    private Credential credential;
    private String companyID;
}
