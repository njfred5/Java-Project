package com.HippyAir.hippyair_backend.Service;
import com.HippyAir.hippyair_backend.Model.Airport;
import com.HippyAir.hippyair_backend.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    // Create a new airport
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Get all airports
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Get airport by ID
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    // Update airport
    public Airport updateAirport(Long id, Airport updated) {
        Airport existing = getAirportById(id);

        existing.setNameAirport(updated.getNameAirport());
        existing.setCountryAirport(updated.getCountryAirport());
        existing.setCityAirport(updated.getCityAirport());

        return airportRepository.save(existing);
    }

    // Delete airport
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}