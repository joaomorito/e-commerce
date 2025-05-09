package com.example.loginauthapi.dto;

import com.example.loginauthapi.domain.Client;

public record ClientResponseDTO(Long id, String name, String email, String cpf) {

    public static ClientResponseDTO fromEntity(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getCpf()
        );
    }
}
