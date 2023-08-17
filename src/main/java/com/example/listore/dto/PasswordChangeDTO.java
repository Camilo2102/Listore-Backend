package com.example.listore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordChangeDTO {
    private String password;
    private String token;
    private String code;
}
