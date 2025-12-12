package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Flight;
import com.HippyAir.hippyair_backend.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create flight
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get flight by flight number
    public Flight getFlightByNumber(String flightNumber) {
        return flightRepository.findById(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    // Update flight
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
        flightRepository.deleteById(flightNumber);
    }
}

