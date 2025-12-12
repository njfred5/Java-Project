package com.HippyAir.hippyair_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HippyAir.hippyair_backend.Model.Flight;

import java.time.LocalDateTime;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    // Search flights by departure/arrival city and departure date
    List<Flight> findByDepartureCityAndArrivalCityAndDepartureHour(
        String departureCity, String arrivalCity, LocalDateTime departureHour
    );
}
