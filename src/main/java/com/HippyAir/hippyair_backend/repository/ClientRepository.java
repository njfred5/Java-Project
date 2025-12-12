package com.HippyAir.hippyair_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // Primary key is passport number (String)
}

