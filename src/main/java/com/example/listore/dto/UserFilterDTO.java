package com.example.listore.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilterDTO {
    private String name;
    private String role;
    private String companyId;

    public UserFilterDTO() {
        this.name = "";
        this.role = "";
        this.companyId = "";
    }
}
