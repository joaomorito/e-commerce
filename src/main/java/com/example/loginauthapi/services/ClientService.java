package com.example.loginauthapi.services;

import com.example.loginauthapi.domain.Client;
import com.example.loginauthapi.dto.ClientRequestDTO;
import com.example.loginauthapi.dto.ClientResponseDTO;
import com.example.loginauthapi.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDTO create(ClientRequestDTO dto) {
        Client saved = clientRepository.save(dto.toEntity());
        return new ClientResponseDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getCpf());
    }

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseDTO::fromEntity)
                .toList();
    }

    public ClientResponseDTO findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        return ClientResponseDTO.fromEntity(client);
    }

    public void updateData(Client client, ClientRequestDTO dto) {
        client.setName(dto.name());
        client.setEmail(dto.email());
        client.setCpf(dto.cpf());
    }

    @Transactional
    public ClientResponseDTO update(Long id, ClientRequestDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        updateData(client, dto);

        return ClientResponseDTO.fromEntity(client);
    }

    public void delete(Long id) {
        Client client = clientRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        clientRepository.delete(client);
    }
}