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
public class Spent extends GeneralModel{

    @Column(nullable = false, length = 60)
    private LocalDateTime spentDate;

    @Column(nullable = false, length = 60)
    private BigDecimal price;

    @Column(nullable = false, length = 180)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ListoreUser user;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime initialDate;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime finalDate;

    public Spent() {
        this.spentDate = LocalDateTime.now();
    }

}
