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
@Entity
@NoArgsConstructor
public class Atributes extends GeneralModel{

    @Column(nullable = false, length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "pattern_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pattern pattern;

    public Atributes(String name, Pattern pattern) {
        this.name = name;
        this.pattern = pattern;
    }
}
