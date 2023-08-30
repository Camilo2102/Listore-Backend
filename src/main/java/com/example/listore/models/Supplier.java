package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Supplier extends  GeneralModel{
    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 10)
    private BigDecimal phone;

    @Column(nullable = false, length = 60)
    private String mail;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(nullable = false, length = 60)
    private String description;

    @ManyToOne
    @JoinColumn(name = "inventory_Id")
    private Inventory inventory;

}
