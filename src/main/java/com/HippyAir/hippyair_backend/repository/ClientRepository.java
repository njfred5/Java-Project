package com.HippyAir.hippyair_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // Primary key is passport number (String)
}

