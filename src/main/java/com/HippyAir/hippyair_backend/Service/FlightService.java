package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Flight;
import com.HippyAir.hippyair_backend.DTO.FlightDTO;
import com.HippyAir.hippyair_backend.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create a new flight
    public Flight createFlight(FlightDTO dto) {
        Flight flight = new Flight();
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setDepartureCity(dto.getDepartureCity());
        flight.setArrivalCity(dto.getArrivalCity());
        flight.setDepartureHour(dto.getDepartureHour());
        flight.setArrivalHour(dto.getArrivalHour());
        flight.setNumberOfSeat(dto.getNumberOfSeat());
        flight.setFirstClassSeatPrice(dto.getFirstClassSeatPrice());
        flight.setPremiumSeatPrice(dto.getPremiumSeatPrice());
        flight.setBusinessClassPrice(dto.getBusinessClassPrice());
        flight.setEconomicsClassPrice(dto.getEconomicsClassPrice());
        // link to Plane and Airports if provided in DTO
        return flightRepository.save(flight);
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get flight by ID
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    // Update flight
    public Flight updateFlight(Long id, FlightDTO dto) {
        Flight flight = getFlightById(id);
        flight.setDepartureCity(dto.getDepartureCity());
        flight.setArrivalCity(dto.getArrivalCity());
        flight.setDepartureHour(dto.getDepartureHour());
        flight.setArrivalHour(dto.getArrivalHour());
        flight.setNumberOfSeat(dto.getNumberOfSeat());
        flight.setFirstClassSeatPrice(dto.getFirstClassSeatPrice());
        flight.setPremiumSeatPrice(dto.getPremiumSeatPrice());
        flight.setBusinessClassPrice(dto.getBusinessClassPrice());
        flight.setEconomicsClassPrice(dto.getEconomicsClassPrice());
        return flightRepository.save(flight);
    }

    // Delete flight
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    // Search flights by departure city, arrival city, and date
    public List<Flight> searchFlights(String departureCity, String arrivalCity, String departureDate) {
        LocalDate date = LocalDate.parse(departureDate);
        return flightRepository.findByDepartureCityAndArrivalCityAndDepartureHourBetween(
                departureCity, arrivalCity, date.atStartOfDay(), date.plusDays(1).atStartOfDay()
        );
    }
}

