package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends GeneralModel  {

    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false, length = 1)
    private char role;

    @OneToOne
    @JoinColumn(name = "credential_id")
    @JsonIgnore
    private Credential credential;

    public User(User user) {
        this.name = user.name;
        this.lastName = user.lastName;
        this.credential = user.credential;
        this.role = user.role;
    }
}
