package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
