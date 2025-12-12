package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
