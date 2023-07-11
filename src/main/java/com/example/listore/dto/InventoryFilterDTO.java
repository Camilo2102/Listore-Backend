package com.example.listore.dto;

import com.example.listore.models.Company;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryFilterDTO {

    private String name;
    private String description;
    private String companyId;
    private String category;

    public InventoryFilterDTO() {
        this.name = "";
        this.description = "";
        this.companyId = "";
        this.category = "";
    }
}
