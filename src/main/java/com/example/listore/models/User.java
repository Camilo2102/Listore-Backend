package com.example.listore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends GeneralModel  {

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 1)
    private String role;

    @Column(nullable = false, length = 1)
    private String active;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public User(User user) {
        this.name = user.name;
        this.credential = user.credential;
        this.role = user.role;
        this.company = user.company;
    }
}
