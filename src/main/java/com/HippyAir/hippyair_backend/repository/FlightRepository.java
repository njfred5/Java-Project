package com.HippyAir.hippyair_backend.repository;

import com.HippyAir.hippyair_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {

    // Search by departure city, arrival city, and departure date
    @Query("SELECT f FROM Flight f " +
           "WHERE f.departureCity = :departureCity " +
           "AND f.arrivalCity = :arrivalCity " +
           "AND f.departureHour >= :departureHourStart " +
           "AND f.departureHour < :departureHourEnd")
    List<Flight> searchFlights(String departureCity,
                               String arrivalCity,
                               LocalDateTime departureHourStart,
                               LocalDateTime departureHourEnd);
}
