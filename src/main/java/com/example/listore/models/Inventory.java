package com.example.listore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Inventory extends GeneralModel {

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false, length = 60)
    private String category;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Inventory(Inventory inventory){
        this.name = inventory.name;
        this.description = inventory.description;
        this.company = inventory.company;
    }
}
