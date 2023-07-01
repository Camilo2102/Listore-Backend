package com.example.listore.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory extends GeneralModel {

    private String edad;

    private  String cedula;

    @Override
    public String toString() {
        return "Inventory{" +
                "edad='" + edad + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }




}
