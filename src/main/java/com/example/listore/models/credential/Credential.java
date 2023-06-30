package com.example.listore.models.credential;

import com.example.listore.models.GeneralModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;

//Entity indica que va a ser una tabla en la base de datos
//Getter y Setter genera getters y setters automaticamente
@Entity
@Getter()
@Setter()
public class Credential extends GeneralModel {

    @Column(nullable = false, length = 60, unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 12, unique = true)
    private String user;

    private String prueba;

    @Override
    public String toString() {
        return "Credential{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
