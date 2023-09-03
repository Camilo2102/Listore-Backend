package com.example.listore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KindOfProduct extends GeneralModel {

    @Column(nullable = false)
    private BigDecimal amount;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "kindOfProduct")
    private List<Characteristic> characteristics;

}
