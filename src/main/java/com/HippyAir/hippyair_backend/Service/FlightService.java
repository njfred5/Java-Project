package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.DTO.FlightDTO;
import com.HippyAir.hippyair_backend.model.Flight;
import com.HippyAir.hippyair_backend.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create new flight
    public Flight createFlight(Flight flight) {
        if (flight.getFlightNumber() == null || flight.getFlightNumber().isBlank()) {
            throw new RuntimeException("Flight number is required");
        }
        if (flightRepository.existsById(flight.getFlightNumber())) {
            throw new RuntimeException("Flight number already exists: " + flight.getFlightNumber());
        }
        return flightRepository.save(flight);
    }

    // Get all flights (entities)
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get flight by ID (entity)
    public Flight getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found: " + flightNumber));
    }

    // Update flight (entity)
    public Flight updateFlight(String flightNumber, Flight flightDetails) {
        Flight flight = getFlightByNumber(flightNumber);

        flight.setDepartureCity(flightDetails.getDepartureCity());
        flight.setArrivalCity(flightDetails.getArrivalCity());
        flight.setDepartureHour(flightDetails.getDepartureHour());
        flight.setArrivalHour(flightDetails.getArrivalHour());
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setPlane(flightDetails.getPlane());
        flight.setNumberOfSeat(flightDetails.getNumberOfSeat());
        flight.setFirstClassSeatPrice(flightDetails.getFirstClassSeatPrice());
        flight.setPremiumSeatPrice(flightDetails.getPremiumSeatPrice());
        flight.setBusinessClassPrice(flightDetails.getBusinessClassPrice());
        flight.setEconomyClassPrice(flightDetails.getEconomyClassPrice());

        return flightRepository.save(flight);
    }

    // Delete flight
    public void deleteFlight(String flightNumber) {
        if (!flightRepository.existsById(flightNumber)) {
            throw new RuntimeException("Flight not found: " + flightNumber);
        }
        flightRepository.deleteById(flightNumber);
    }

    // Search flights by city/date
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime departureHour) {
        LocalDateTime startOfDay = departureHour.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        return flightRepository.searchFlights(departureCity, arrivalCity, startOfDay, endOfDay);
    }

    // ✅ DTO mapping
    public FlightDTO toDTO(Flight f) {
        FlightDTO dto = new FlightDTO();
        dto.setFlightNumber(f.getFlightNumber());
        dto.setDepartureCity(f.getDepartureCity());
        dto.setArrivalCity(f.getArrivalCity());
        dto.setDepartureHour(f.getDepartureHour());
        dto.setArrivalHour(f.getArrivalHour());
        dto.setNumberOfSeat(f.getNumberOfSeat());
        dto.setEconomyClassPrice(f.getEconomyClassPrice());
        return dto;
    }

    public List<FlightDTO> getAllFlightsDTO() {
        return getAllFlights().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FlightDTO getFlightDTO(String flightNumber) {
        return toDTO(getFlightByNumber(flightNumber));
    }

    public List<FlightDTO> searchFlightsDTO(String departureCity, String arrivalCity, LocalDateTime departureHour) {
        return searchFlights(departureCity, arrivalCity, departureHour).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
