package com.restaurante.restaurante.repository;

import com.restaurante.restaurante.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
