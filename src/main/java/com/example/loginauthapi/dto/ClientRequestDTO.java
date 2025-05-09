package com.example.loginauthapi.dto;

import com.example.loginauthapi.domain.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequestDTO(@NotBlank(message = "Name is mandatory") String name,

                               @NotBlank(message = "Email is mandatory")
                               @Email(message = "Invalid email") String email,

                               @NotBlank(message = "cpf is mandatory") String cpf) {

    public Client toEntity() {
        return new Client(name, email, cpf);
    }
}
