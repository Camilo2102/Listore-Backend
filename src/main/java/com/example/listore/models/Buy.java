package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Buy extends GeneralModel{

    @Column(nullable = false, length = 60)
    private LocalDateTime buyDate;

    @Column(nullable = false, length = 60)
    private BigDecimal price;

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

    public Buy(Buy buy) {
        this.buyDate = buy.buyDate;
        this.price = buy.price;
        this.amount = buy.amount;
        this.product = buy.product;
        this.user = buy.user;
    }
}
