package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.DTO.FlightDTO;
import com.HippyAir.hippyair_backend.model.Flight;
import com.HippyAir.hippyair_backend.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Create flight
    @PostMapping
    public ResponseEntity<FlightDTO> createFlight(@RequestBody Flight flight) {
        Flight saved = flightService.createFlight(flight);
        return ResponseEntity.ok(flightService.toDTO(saved));
    }

    // Get all flights
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlightsDTO();
    }

    // Get flight by ID
    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable String flightNumber) {
        return ResponseEntity.ok(flightService.getFlightDTO(flightNumber));
    }

    // Update flight
    @PutMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable String flightNumber, @RequestBody Flight flight) {
        flight.setFlightNumber(flightNumber); // enforce ID consistency
        Flight updated = flightService.updateFlight(flightNumber, flight);
        return ResponseEntity.ok(flightService.toDTO(updated));
    }

    // Delete flight
    @DeleteMapping("/{flightNumber}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String flightNumber) {
        flightService.deleteFlight(flightNumber);
        return ResponseEntity.noContent().build();
    }

    // Search flights
    @GetMapping("/search")
    public List<FlightDTO> searchFlights(@RequestParam String departureCity,
                                         @RequestParam String arrivalCity,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureHour) {
        return flightService.searchFlightsDTO(departureCity, arrivalCity, departureHour);
    }
}
