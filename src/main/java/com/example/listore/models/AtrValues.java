package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class AtrValues extends GeneralModel {

    @Column(nullable = false, length = 60)
    private String value;

    @ManyToOne
    @JoinColumn(name = "atributes_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Atributes atributes;

    @ManyToOne
    @JoinColumn(name = "values_id")
    private AtrValues values;

}
