package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
