package com.example.listore.credential;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Entity indica que va a ser una tabla en la base de datos
//Getter y Setter genera getters y setters automaticamente
@Entity
@Getter()
@Setter()
public class Credential {

    //Sempre debe existir un id
    @Id
    @Column(length = 36)
    private String id;

    @Column(nullable = false, length = 60, unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 12, unique = true)
    private String user;



    @Override
    public String toString() {
        return "Credential{" +
                "id='" + id + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
