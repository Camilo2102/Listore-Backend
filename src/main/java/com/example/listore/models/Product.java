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
@NoArgsConstructor
public class Product extends GeneralModel{
    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private BigDecimal unitaryValue;

    @Column(nullable = false, length = 60)
    private BigDecimal wholeSalePrice;

    @ManyToOne
    @JoinColumn(name="supplier_Id ")
    private Supplier supplier;

    @Column(nullable = false, length = 60)
    private String category;

    @ManyToOne
    @JoinColumn(name = "inventory_Id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Inventory inventory;

    @Column(nullable = false, length = 60)
    private BigDecimal amount;


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", unitaryValue=" + unitaryValue +
                ", wholeSalePrice=" + wholeSalePrice +
                ", supplier=" + supplier +
                ", category='" + category + '\'' +
                ", inventory=" + inventory +
                ", amount=" + amount +
                '}';
    }
}
