package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Characteristic extends GeneralModel{

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private String value;

    @ManyToOne
    @JoinColumn(name = "kind_of_product_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private KindOfProduct kindOfProduct;
}
