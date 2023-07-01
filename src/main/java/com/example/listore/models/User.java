package com.example.listore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @OneToOne
    private Credential credential;

    public User(User user) {
        this.name = user.name;
        this.lastName = user.lastName;
        this.credential = user.credential;
    }
}
