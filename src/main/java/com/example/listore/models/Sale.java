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
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Sale extends GeneralModel{

    @Column(nullable = false, length = 60)
    private LocalDateTime saleDate;

    @Column(nullable = false, length = 60)
    private BigDecimal unitaryValue;

    @Column(nullable = false, length = 60)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Sale(Sale sale) {
        this.saleDate = sale.saleDate;
        this.unitaryValue = sale.unitaryValue;
        this.amount = sale.amount;
        this.product = sale.product;
        this.user = sale.user;
    }
}
