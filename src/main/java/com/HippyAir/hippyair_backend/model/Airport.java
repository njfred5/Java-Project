package com.HippyAir.hippyair_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAirport;

    private String nameAirport;
    private String countryAirport;
    private String cityAirport;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlights;

    // getters and setters
}
