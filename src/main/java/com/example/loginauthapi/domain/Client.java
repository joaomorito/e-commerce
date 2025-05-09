package com.example.loginauthapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;

    public Client() {}

    public Client(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
}
