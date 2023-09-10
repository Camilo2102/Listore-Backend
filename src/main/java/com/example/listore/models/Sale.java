package com.example.listore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Sale extends GeneralModel{

    @Column(nullable = false, length = 60)
    private LocalDateTime saleDate;

    @Column(nullable = false, length = 60)
    private BigDecimal unitaryValue;

    @Column(nullable = false, length = 60)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private ListoreUser user;

    // No persistence fields
    @Transient
    private LocalDateTime initialDate;

    @Transient
    private LocalDateTime finalDate;

    public Sale() {
        this.saleDate = LocalDateTime.now();
    }
}
