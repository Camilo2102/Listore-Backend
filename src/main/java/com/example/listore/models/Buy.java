package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Buy extends GeneralModel{

    @Column(nullable = false, length = 60)
    private LocalDateTime buyDate;

    @Column(nullable = false, length = 60)
    private BigDecimal price;

    @Column(nullable = false, length = 60)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "kind_of_product_id")
    private KindOfProduct kindOfProduct;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ListoreUser user;

    @Transient
    private LocalDateTime initialDate;

    @Transient
    private LocalDateTime finalDate;

    public Buy() {
        this.buyDate = LocalDateTime.now();
    }
}
